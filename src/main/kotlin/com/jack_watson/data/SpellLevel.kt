package com.jack_watson.data

enum class SpellLevel(val number: Int, val writtenName: String) {
    CANTRIP(0, "Cantrip"),
    FIRST(1, "1st-level"),
    SECOND(2, "2nd-level"),
    THIRD(3, "3rd-level"),
    FOURTH(4, "4th-level"),
    FIFTH(5, "5th-level"),
    SIXTH(6, "6th-level"),
    SEVENTH(7, "7th-level"),
    EIGHTH(8, "8th-level"),
    NINTH(9, "9th-level");

    companion object {
        fun getWrittenNames(): ArrayList<String> {
            val writtenNames = ArrayList<String>()
            (SpellLevel.values().forEach { level -> writtenNames.add(level.writtenName) })
            return writtenNames
        }

        fun getAssociatedLevelEnum(text: String): SpellLevel? {
            for (level in SpellLevel.values()) {
                if(level.writtenName == text) {
                    return level
                }
            }
            return null
        }
    }

    override fun toString(): String {
        return writtenName
    }
}