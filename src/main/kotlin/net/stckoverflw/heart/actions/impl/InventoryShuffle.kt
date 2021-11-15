package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player

object InventoryShuffle : DamageAction("Inventory shuffle") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        player.inventory.contents = player.inventory.shuffled().toTypedArray()
        return Pair(this, null)
    }
}