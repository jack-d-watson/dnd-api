package com.jack_watson.bean

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.jack_watson.data.Spell
import com.jack_watson.data.SpellComponents
import com.jack_watson.data.SpellLevel
import java.io.IOException

class SpellDeserializer {
    companion object {
        @Throws(IOException::class, JsonProcessingException::class)
        fun deserialize(node: JsonNode): Spell {
            var spell = Spell()

            spell.name = node.get("name").asText()
            spell.school = node.get("school").asText()

            var level = mapSpellLevel(node.get("level").asText())
            if (level == null) {
                spell.level = SpellLevel.CANTRIP
            } else {
                spell.level = level
            }

            spell.castingTime = node.get("casting_time").asText()
            spell.range = node.get("range").asText()
            spell.components = mapSpellComponents(node.get("components"))
            if (node.has("material")) {
                spell.components.materialComponents = node.get("material").asText()
            }
            spell.duration = node.get("duration").asText()
            spell.spellText = node.get("desc").asText()
            if (node.has("higher_level")) {
                spell.higherLevelText = node.get("higher_level").asText()
            }
            spell.concentration = node.get("concentration").asBoolean()
            spell.ritualCasting = node.get("ritual").asBoolean()
            spell.source = node.get("page").asText()
            spell.classes = ArrayList(node.get("class").asText().split(","))

            return spell
        }

        private fun mapSpellComponents(node: JsonNode): SpellComponents {
            var components = SpellComponents()
            val tokens = node.asText().split(",")
            for (token in tokens) {
                when (token) {
                    "V" -> components.hasVerbal = true
                    "S" -> components.hasSomatic = true
                    "M" -> components.hasMaterial = true
                }
            }
            return components
        }

        private fun mapSpellLevel(levelText: String): SpellLevel? {
            return SpellLevel.getAssociatedLevelEnum(levelText)
        }
    }
}