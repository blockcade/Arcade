package net.blockcade.arcade

import net.blockcade.arcade.managers.gui.Interface
import net.blockcade.arcade.managers.gui.InterfaceManager
import net.blockcade.arcade.managers.items.Item
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Arcade() : JavaPlugin() {

    companion object {
        var instance: Arcade? = null
    }

    init {
        instance = this
    }

    override fun onEnable() {

        var interfaceManager: InterfaceManager = InterfaceManager();
        var intf: Interface = interfaceManager.createInterface("Test", 9);

        var testItem: Item = Item(Material.STONE, "Test Item");
        testItem.onClick {
            player -> player.sendMessage("This is a test!")
        }
        intf.setItem(testItem, 0, 0);
        interfaceManager.registerInterface(intf);

    }

}
