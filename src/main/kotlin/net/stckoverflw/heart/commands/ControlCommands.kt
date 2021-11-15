package net.stckoverflw.heart.commands

import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs
import net.stckoverflw.heart.actions.DamageActionManager
import kotlin.Exception

fun startCommand() = command("start-game", true) {
    runs {
        DamageActionManager.enable()
        sender.sendMessage("§7Game started")
    }
}

fun stopCommand() = command("stop-game", true) {
    runs {
        try {
            DamageActionManager.disable()
            sender.sendMessage("§7Game stopped")
        } catch (ex: Exception) {
            sender.sendMessage("§cThe Game is not started yet")
        }

    }
}

fun toggleMessageCommand() = command("toggle-message", true) {
    runs {
        DamageActionManager.broadcastMessage = !DamageActionManager.broadcastMessage
        sender.sendMessage("§7Broadcast Message is now: §9" + DamageActionManager.broadcastMessage)
    }
}