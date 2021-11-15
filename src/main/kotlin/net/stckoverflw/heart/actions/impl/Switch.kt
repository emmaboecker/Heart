package net.stckoverflw.heart.actions.impl

import net.axay.kspigot.extensions.onlinePlayers
import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player

object Switch : DamageAction("Swap") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        onlinePlayers.forEachIndexed { index, current ->
            try {
                current.teleportAsync(onlinePlayers.toList()[index + 1].location)
            } catch (ex: IndexOutOfBoundsException) {
                current.teleportAsync(onlinePlayers.toList()[0].location)
            }
        }
        return Pair(this, null)
    }
}