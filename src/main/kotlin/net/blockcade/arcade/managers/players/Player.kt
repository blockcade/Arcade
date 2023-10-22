package net.blockcade.arcade.managers.players

import org.bukkit.entity.Player

class Player(player: Player) {

    private var mcPlayer: Player = player;
    private var metrics: PlayerMetrics = PlayerMetrics()

    fun getMetrics(): PlayerMetrics {
        return metrics;
    }

    fun getLegacy(): Player {
        return this.mcPlayer;
    }

}
