/**
 * 
 */
package de.gero.arcanebotany.items.misc;

import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * @author Gero
 *
 */
public class ItemGardenersChest extends GardenersArmor {

	public ItemGardenersChest(ArmorMaterial mat, int p_i45325_2_, int slot) {
		super(mat, p_i45325_2_, slot);
		setTextureName(ModInfo.ID + "itemGardenersChest");
		setUnlocalizedName("itemGardenersChest");
	}
}
