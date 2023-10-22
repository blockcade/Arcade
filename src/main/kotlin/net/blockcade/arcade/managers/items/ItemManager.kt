package net.blockcade.arcade.managers.items

import net.blockcade.arcade.Arcade
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import java.util.UUID

class ItemManager {

    private var items: HashMap<UUID, Item> = HashMap()

    fun getItem(uuid: UUID): Item? {
        return items[uuid]
    }

    fun getItem(itemStack: ItemStack): Item? {
        val namespacedKey: NamespacedKey = NamespacedKey(Arcade.instance!!, "uuid")

        if (!itemStack.hasItemMeta()) return null;
        if (!itemStack.itemMeta!!.persistentDataContainer.isEmpty) return null;
        if (!itemStack.itemMeta!!.persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) return null;

        val uuid: UUID = UUID.fromString(itemStack.itemMeta!!.persistentDataContainer.get(namespacedKey, PersistentDataType.STRING))

        return items[uuid]
    }

    fun registerItem(item: Item) {
        items[item.uuid] = item
    }

}
