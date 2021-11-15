package net.stckoverflw.heart.actions.impl

import net.axay.kspigot.extensions.geometry.minus
import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.util.Vector

object Explosion : DamageAction("Explosion") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        val front = player.getLineOfSight(Material.values().toSet(), 5)[1]
        val frontLocation = front.location.clone().minus(Vector(0.0, 1.0, 0.0))
        player.world.createExplosion(frontLocation, 1F, true)
        return Pair(this, null)
    }
}