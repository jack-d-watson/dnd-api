package com.jack_watson.data

data class Spell (
    var name: String,
    var school: String,
    var level: SpellLevel,
    var castingTime: String,
    var range: String,
    var components: SpellComponents,
    var duration: String,
    var spellText: String,
    var higherLevelText: String,
    var concentration: Boolean,
    var ritualCasting: Boolean,
    var source: String,
    var classes: ArrayList<String>
) : Comparable<Spell> {
    constructor() : this(
        "",
        "",
        SpellLevel.CANTRIP,
        "",
        "",
        SpellComponents(false, false, false, null),
        "",
        "",
        "",
        false,
        false,
        "",
        ArrayList<String>()
    )

    override operator fun compareTo(other: Spell): Int {
        if(this.level.compareTo(other.level) == 0) {
            return this.name.compareTo(other.name)
        }
        return this.level.compareTo(other.level)
    }

}