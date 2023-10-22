package net.blockcade.arcade.managers.spectate

import net.blockcade.arcade.managers.game.GameManager
import net.blockcade.arcade.managers.items.Item
import net.blockcade.arcade.managers.players.Player
import org.bukkit.GameMode
import org.bukkit.Material

class SpectatorManager {

    var spectators: ArrayList<Spectator> = ArrayList()
    var items: HashMap<String, Item> = HashMap()

    constructor() {
        var playerSelectorItem: Item = Item(Material.COMPASS, "&ePlayer Selector");
        playerSelectorItem.onClick {
            player -> GameManager.gameManager.interfaceManager.getInterfaceByName("player_selector")?.open(player)
        }
        items.put(playerSelectorItem.name, playerSelectorItem);
    }

    fun playerToSpectator(player: Player, reason: SpectateReason) {
        spectators.add(Spectator(player, reason))
    }

}
