package net.stckoverflw.heart.actions.impl

import net.stckoverflw.heart.actions.DamageAction
import org.bukkit.entity.Player

object ItemRemove : DamageAction("Item Remove") {
    override fun action(player: Player): Pair<DamageAction, String?> {
        player.inventory.setItemInMainHand(null)
        return Pair(this, null)
    }
}