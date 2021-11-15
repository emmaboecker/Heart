package net.stckoverflw.heart.actions.impl

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.unregister
import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

object LightningSpawn : DamageAction("Lightning Strike") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        val listener = listen<EntityDamageEvent> {
            if (it.entity == player) {
                it.damage = 1.0
            }
        }
        player.world.strikeLightning(player.location)
        listener.unregister()
        return Pair(this, null)
    }
}