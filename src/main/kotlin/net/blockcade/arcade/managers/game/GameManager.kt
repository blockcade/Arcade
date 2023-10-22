package net.blockcade.arcade.managers.game

import net.blockcade.arcade.managers.game.variables.GameState
import net.blockcade.arcade.managers.gui.InterfaceManager
import net.blockcade.arcade.managers.players.PlayerManager
import net.blockcade.arcade.managers.teams.TeamManager

class GameManager() {

    companion object {
        var gameManager: GameManager? = null
    }

    // Static game variables
    var gameState: GameState = GameState.LOBBY

    // Define other managers
    var interfaceManager: InterfaceManager = InterfaceManager()
    var playerManager: PlayerManager = PlayerManager()
    var teamManager: TeamManager = TeamManager()

    init {
        GameManager.gameManager = this
    }

    // Helper Methods



}
