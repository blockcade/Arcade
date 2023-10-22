package net.blockcade.arcade.managers.items

import net.blockcade.arcade.Arcade
import net.blockcade.arcade.utils.Text
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType
import java.util.*
import kotlin.collections.ArrayList

class Item(var material: Material, var name: String) {

    var uuid: UUID = UUID.randomUUID();
    var lore: ArrayList<String> = ArrayList();
    var attributes: ArrayList<ItemAttribute> = ArrayList();
    var click: (player: Player) -> Unit = {};

    fun addAttribute(attribute: ItemAttribute) {
        this.attributes.add(attribute);
    }

    fun onClick(click: (player: Player) -> Unit) {
        this.click = click;
    }

    fun setMaterial(material: Material) {
        this.material = material;
    }

    fun setName(name: String) {
        this.name = name;
    }

    fun setLore(lore: ArrayList<String>) {
        this.lore = lore;
    }

    fun click(click: (player: Player) -> Unit) {
        this.click = click;
    }

    fun asLegacy(): ItemStack {
        var istack: ItemStack = ItemStack(material);
        var imeta: ItemMeta = istack.itemMeta!!;

        imeta.setDisplayName(Text.parseFormatting(name));
        imeta.lore = lore;
        imeta.persistentDataContainer.set(NamespacedKey(Arcade.instance!!, "uuid"), PersistentDataType.STRING, this.uuid.toString());
        istack.itemMeta = imeta;

        return istack;
    }
}
