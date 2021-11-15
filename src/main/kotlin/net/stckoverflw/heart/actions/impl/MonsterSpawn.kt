package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player

object MonsterSpawn : DamageAction("Monster Spawn") {

    private val monsters = mapOf(
        Pair(EntityType.CREEPER, 1..10),
        Pair(EntityType.ZOMBIE, 5..10),
        Pair(EntityType.RAVAGER, 1..2),
        Pair(EntityType.BLAZE, 1..10),
        Pair(EntityType.SILVERFISH, 1..10),
    )

    override fun action(player: Player): Pair<DamageAction, String?> {
        val monster = monsters.entries.random()
        val count = monster.value.random()
        for (i in 1..count) {
            player.world.spawnEntity(player.location, monster.key)
        }
        return Pair(this, (count.toString()+ " " + monster.key.entityClass?.name?.replace("org.bukkit.entity.", "") + " (run!)"))
    }
}