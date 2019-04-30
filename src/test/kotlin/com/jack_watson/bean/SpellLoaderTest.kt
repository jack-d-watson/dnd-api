package com.jack_watson.bean

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.test.context.ContextConfiguration

@RunWith(MockitoJUnitRunner::class)
@ContextConfiguration
class SpellLoaderTest {

    private val spellLoader = SpellLoader()

    @Test
    fun `Spell Loader Returns Spells` () {
        val returnedSpell = spellLoader.getSpell("Augury")
        assertThat(returnedSpell).isNotNull
    }
}