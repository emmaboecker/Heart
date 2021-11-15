package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player

object MobSpawn : DamageAction("Mob Spawn") {
    private val animals = mapOf(
        Pair(EntityType.CHICKEN, 10..20),
        Pair(EntityType.BAT, 10..30),
        Pair(EntityType.COD, 15..30),
        Pair(EntityType.GIANT, 1..1),
        Pair(EntityType.BEE, 5..15),
    )

    override fun action(player: Player): Pair<DamageAction, String?> {
        val mob = animals.entries.random()
        val count = mob.value.random()
        for (i in 1..count) {
            player.world.spawnEntity(player.location, mob.key)
        }
        return Pair(this, (count.toString()+ " " + mob.key.entityClass?.name?.replace("org.bukkit.entity.", "")))
    }
}