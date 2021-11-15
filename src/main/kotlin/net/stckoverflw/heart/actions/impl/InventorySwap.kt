package net.stckoverflw.heart.actions.impl

import net.axay.kspigot.extensions.onlinePlayers
import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player

object InventorySwap : DamageAction("Inventory Swap") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        onlinePlayers.forEachIndexed { index, current ->
            try {
                current.inventory.contents = onlinePlayers.toList()[index + 1].inventory.contents
            } catch (ex: IndexOutOfBoundsException) {
                current.inventory.contents = onlinePlayers.toList()[0].inventory.contents
            }
        }
        return Pair(this, null)
    }
}