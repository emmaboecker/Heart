package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player

object RandomTeleport : DamageAction("Random Teleport") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        val lastLocation = player.location.clone()
        val nearbyEntity = player.getNearbyEntities(100.0, 50.0, 100.0).last()
        nearbyEntity.remove()
        player.teleportAsync(nearbyEntity.location)

        return Pair(this, nearbyEntity.location.clone().distance(lastLocation).toInt().toString() + " blocks away")
    }
}