package net.stckoverflw.heart

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.main.KSpigot
import net.stckoverflw.heart.commands.startCommand
import net.stckoverflw.heart.commands.stopCommand
import net.stckoverflw.heart.commands.toggleMessageCommand

class HeartPlugin : KSpigot() {

    override fun startup() {
        startCommand()
        stopCommand()
        toggleMessageCommand()

        logger.info("${KColors.GREEN}The Plugin was successfully enabled!")
    }

    override fun shutdown() {
        logger.info("${KColors.RED}The Plugin was disabled!")
    }

}