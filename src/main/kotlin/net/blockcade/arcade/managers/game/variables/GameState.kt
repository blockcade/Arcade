package net.blockcade.arcade.managers.game.variables

enum class GameState {
    PREPARING, // Initial state and waiting state while we await start conditions
    PRE_START, // State used for starting behaviours (e.g. countdown)
    STARTED, // Players are actively playing the game
    ENDED,// Game has ended, but we are doing any awards or end of game behaviour. This is also when stats are pushed to the database
    CLEANING_UP // Players are removed from the server, and once completed the server will shut down
}
