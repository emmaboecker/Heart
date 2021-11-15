package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player

object TntSpawn : DamageAction("TNT Spawn") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        player.world.spawnEntity(player.location, EntityType.PRIMED_TNT)
        return Pair(this, null)
    }
}