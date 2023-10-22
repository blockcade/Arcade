package net.blockcade.arcade.managers.spectate

import net.blockcade.arcade.managers.players.Player
import org.bukkit.GameMode

class Spectator {

    var player: Player

    constructor(player: Player, reason: SpectateReason) {
        this.player = player

        // Convert to spectator
        player.getLegacy().gameMode = GameMode.ADVENTURE;
        player.getLegacy().allowFlight = true
        player.getLegacy().isFlying = true

        // Give spectator items depending on reason
        if (reason == SpectateReason.ELIMINATION) {

        }

    }

}
