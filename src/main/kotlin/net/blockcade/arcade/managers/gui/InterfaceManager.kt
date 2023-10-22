package net.blockcade.arcade.managers.gui

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory

class InterfaceManager {

    private var interfaces: HashMap<String, Interface> = HashMap();

    fun createInterface(name: String, size: Int): Interface {
        return Interface(name, size);
    }

    fun registerInterface(name: String, inf: Interface) {
        interfaces[name] = inf;
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val interfaceByInventory: Interface = getInterfaceByInventory(event.inventory) ?: return;
        interfaceByInventory.getItem(event.rawSlot)?.click?.let { it(event.whoClicked as Player) };
    }

    fun getInterfaceByName(name: String): Interface? {
        return interfaces[name];
    }

    fun getInterfaceByInventory(inventory: Inventory): Interface? {
        return interfaces.values.find { it.inventory == inventory };
    }

}
