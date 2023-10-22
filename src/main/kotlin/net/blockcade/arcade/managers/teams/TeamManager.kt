package net.blockcade.arcade.managers.teams

class TeamManager {

    private var teams: ArrayList<Team> = ArrayList()

    fun getTeams(): ArrayList<Team> {
        return teams
    }

    fun addTeam(team: Team) {
        teams.add(team)
    }



}
