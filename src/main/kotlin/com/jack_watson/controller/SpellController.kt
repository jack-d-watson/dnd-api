package com.jack_watson.controller

import com.jack_watson.bean.SpellLoader
import com.jack_watson.data.Spell
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpellController {

    @Autowired
    lateinit var spellData: SpellLoader

    @GetMapping("/spell/{name}")
    fun spellWithName(@PathVariable name: String): Spell? = spellData.getSpell(name)

    @GetMapping("/spells/class-list/{className}")
    fun spellListForClass(@PathVariable className: String): List<Spell>? = spellData.getSpellListForClass(className)

    @GetMapping("/spells/by-level/{level}")
    fun spellsByLevel(@PathVariable level: String): List<Spell>? = spellData.getSpellListByLevel(level)

}