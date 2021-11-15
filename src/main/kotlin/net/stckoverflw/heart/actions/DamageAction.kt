package net.stckoverflw.heart.actions

import org.bukkit.entity.Player

abstract class DamageAction(val name: String) {

    /**
     * This function gets called when a Player takes damage
     *
     * @param player The player that took damage
     * @return pair of the Action triggered and extra information
     */
    abstract fun action(player: Player): Pair<DamageAction, String?>

}