package com.jack_watson.data

data class SpellComponents(
    var hasVerbal: Boolean,
    var hasSomatic: Boolean,
    var hasMaterial: Boolean,
    var materialComponents: String?
) {
    constructor() : this(false, false, false, null)
}
