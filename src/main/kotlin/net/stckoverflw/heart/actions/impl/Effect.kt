package net.stckoverflw.heart.actions.impl

import net.axay.kspigot.extensions.onlinePlayers
import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Effect : DamageAction("Random Effect") {

    private val effects = listOf(
        TriggeredEffect("Levitation 10s", PotionEffect(
            PotionEffectType.LEVITATION,
            10 * 20,
            6,
            true,
            false,
            true,
        )),
        TriggeredEffect("Blindness 5s", PotionEffect(
            PotionEffectType.BLINDNESS,
            5 * 20,
            50,
            true,
            false,
            true,
        )),
        TriggeredEffect("Slowness 5s", PotionEffect(
            PotionEffectType.SLOW,
            5 * 20,
            3,
            true,
            false,
            true,
        )),
    )

    override fun action(player: Player): Pair<DamageAction, String> {
        val effect = effects.random()
        onlinePlayers.forEach {
            it.addPotionEffect(effect.potionEffect)
        }
        return Pair(this, effect.name)
    }

    private data class TriggeredEffect(val name: String, val potionEffect: PotionEffect)
}