/*
 *
 *  *
 *  * © Stelch Software 2019, distribution is strictly prohibited
 *  * Blockcade is a company of Stelch Software
 *  *
 *  * Changes to this file must be documented on push.
 *  * Unauthorised changes to this file are prohibited.
 *  *
 *  * @author Ryan Wood
 *  @since 18/8/2019
 */

/*
 *
 *  *
 *  * © Stelch Software 2019, distribution is strictly prohibited
 *  * Blockcade is a company of Stelch Software
 *  *
 *  * Changes to this file must be documented on push.
 *  * Unauthorised changes to this file are prohibited.
 *  *
 *  * @author Ryan Wood
 *  @since 22/7/2019
 */

/*
 *
 * *
 *  *
 *  * © Stelch Games 2019, distribution is strictly prohibited
 *  *
 *  * Changes to this file must be documented on push.
 *  * Unauthorised changes to this file are prohibited.
 *  *
 *  * @author Ryan Wood
 *  * @since 16/7/2019
 *
 */

package net.blockcade.Arcade.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Hashtable;

public class JavaUtils {

    public static enum TimeUnit {
        MILI("Milliseconds ",1),
        SECOND("Seconds",1000),
        MINUTE("Minutes",60000);
        private String translated;
        private int division;
        TimeUnit(String translated, int division){
            this.translated=translated;this.division=division;
        }
    }

    public static String center(String str, int size) {
        int left = (size - str.length()) / 2;
        int right = size - left - str.length();
        String repeatedChar = " ";
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < left; i++) {
            buff.append(repeatedChar);
        }
        buff.append(str);
        for (int i = 0; i < right; i++) {
            buff.append(repeatedChar);
        }
        return (buff.toString());
    }

    public static BlockFace direction(Float heading)
    {
        BlockFace strHeading = BlockFace.NORTH;
        Hashtable<BlockFace, Float> cardinal = new Hashtable<BlockFace, Float>();
        cardinal.put(BlockFace.NORTH, new Float(0));
        cardinal.put(BlockFace.NORTH, new Float(45));
        cardinal.put(BlockFace.EAST, new Float(90));
        cardinal.put(BlockFace.EAST, new Float(135));
        cardinal.put(BlockFace.SOUTH, new Float(180));
        cardinal.put(BlockFace.SOUTH, new Float(225));
        cardinal.put(BlockFace.WEST, new Float(270));
        cardinal.put(BlockFace.WEST, new Float(315));
        cardinal.put(BlockFace.NORTH, new Float(360));

        for (BlockFace key: cardinal.keySet())
        {
            Float value = cardinal.get(key);
            if (Math.abs(heading - value) < 30)
            {
                strHeading = key;
                break;
            }
        }
        return strHeading;
    }

    public static ArrayList<Material> getMatFromItemstack(ArrayList<ItemStack> items){
        ArrayList<Material> mats = new ArrayList<>();
        for(ItemStack is : items){
            if(is!=null)mats.add(is.getType());
        }
        return mats;
    }

    public static Location parseConfigLocation(String raw_loc) {
        String[] loc_data = raw_loc.split("[:]");
        return new Location(Bukkit.getWorld(loc_data[0]), Double.parseDouble(loc_data[1]), Double.parseDouble(loc_data[2]), Double.parseDouble(loc_data[3]));
    }

    public static long FormatMS(Long time, TimeUnit timeUnit){
        /*
        TimeUnit timeUnit = TimeUnit.MILI;
        if(time>60000){timeUnit=TimeUnit.MINUTE;}
        if((time<60000)){timeUnit=TimeUnit.SECOND;}
        if((time<1000)){timeUnit=TimeUnit.MILI;}
        */

        return ((time==0?1:time)/timeUnit.division);
    }

}
