package net.blockcade.arcade.managers.players

class PlayerMetrics {

    var deaths: Int = 0
    var kills: Int = 0
    var assists: Int = 0

    fun addDeath() {
        deaths++
    }

    fun addKill() {
        kills++
    }

    fun addAssist() {
        assists++
    }

}
