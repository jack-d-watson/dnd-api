package com.jack_watson.bean

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.jack_watson.data.Spell
import com.jack_watson.data.SpellLevel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.logging.Logger

@Service
class SpellLoader @Autowired constructor() {
    companion object {
        val LOGGER = Logger.getLogger("SpellLoader")
    }

    var spellMap = HashMap<String, Spell>()

    var classList = ArrayList<String>()

    init {
        //Gets us ready to read the json
        val spellJsonFile: InputStream = Files.newInputStream(Paths.get("src/main/resources/spells.json"))
        val factory = JsonFactory()
        val mapper = ObjectMapper(factory)

        //The whole JSON thing
        val rootNode = mapper.readTree(spellJsonFile)["jsonSpellData"]

        if(rootNode.isArray) {
            for (objNode in rootNode) {
                var spell = SpellDeserializer.deserialize(objNode)
                spellMap["${spell.name}"] = spell

                for(className in spell.classes) {
                    if(!classList.contains(className)) {
                        classList.add(className)
                    }
                }
            }
        }

    }

    fun getSpell(name: String): Spell? = spellMap[name]

    fun getSpellListForClass(className: String): List<Spell>?{
        if(!classList.contains(className)) {
            return null
        }

        return ArrayList(spellMap.values.filter { it.classes.contains(className) }).sortedBy { it }
    }

    fun getSpellListByLevel(level: String): List<Spell>? {
        if(SpellLevel.getWrittenNames().contains(level).not()) {
            return null
        }

        return ArrayList(spellMap.values.filter { it.level.writtenName == level})
    }

}