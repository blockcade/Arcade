package net.blockcade.arcade.utils

import org.bukkit.ChatColor

class Text {

    companion object {
        fun parseFormatting(text: String): String {
            return ChatColor.translateAlternateColorCodes('&', text);
        }
    }

}
