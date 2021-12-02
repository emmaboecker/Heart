package net.stckoverflw.heart.actions

import net.axay.kspigot.event.SingleListener
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.unregister
import net.axay.kspigot.extensions.broadcast
import net.stckoverflw.heart.actions.impl.*
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

object DamageActionManager {

    lateinit var listener: SingleListener<EntityDamageEvent>

    var lastAction: DamageAction? = null

    var broadcastMessage: Boolean = true

    private val actions = listOf(
        Effect,
        Explosion,
        ItemRemove,
        TntSpawn,
        Switch,
        MobSpawn,
        MonsterSpawn,
        InventoryShuffle,
        RandomTeleport,
        LightningSpawn,
        InventorySwap,
    )

    fun enable() {
        listener = listen {
            if (it.entity is Player && it.finalDamage > 0) {
                var newAction = actions.random()
                while (lastAction == newAction) {
                    newAction = actions.random()
                }
                lastAction = newAction
                val action = newAction.action(it.entity as Player)
                if (broadcastMessage) {
                    broadcast(
                        "§7${it.entity.name} took damage and triggered ${action.first.name} ".plus(
                            if (action.second != null) "(${action.second})" else ""
                        )
                    )
                }
            }
        }
    }

    fun disable() {
        listener.unregister()
    }

}