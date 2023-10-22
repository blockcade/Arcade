package net.blockcade.arcade.managers.teams

import net.blockcade.arcade.managers.players.Player

class Team(var players: List<Player>) {

    var eliminated: Boolean = false

    fun setEliminated(state: Boolean) {
        this.eliminated = state
    }

    fun getEliminated(): Boolean {
        return this.eliminated
    }

    fun getPlayers(): List<Player> {
        return players
    }

}
