package net.blockcade.arcade.managers.gui

import net.blockcade.arcade.managers.items.Item
import net.blockcade.arcade.managers.players.Player
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

class Interface(var name: String, var size: Int) {

    private var itemMap: HashMap<Int, Item> = HashMap();

    fun getItem(slot: Int): Item? {
        return itemMap[slot];
    }

    fun setItem(item: Item, slot: Int) {
        itemMap[slot] = item;
    }

    fun setItem(item: Item, y: Int, x: Int) {
        setItem(item, x + y * 9);
    }

    fun asLegacy(): Inventory {
        var inventory: Inventory = Bukkit.createInventory(null, size, name);
        itemMap.forEach { (slot, item) -> inventory.setItem(slot, item.asLegacy()) };
        return inventory;
    }

    fun open(player: Player) {
        player.getLegacy().openInventory(inventory);
    }

}
