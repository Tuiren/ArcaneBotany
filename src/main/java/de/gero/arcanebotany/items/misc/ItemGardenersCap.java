/**
 * 
 */
package de.gero.arcanebotany.items.misc;

import thaumcraft.api.nodes.IRevealer;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * @author Gero
 *
 */
public class ItemGardenersCap extends GardenersArmor implements IRevealer {

	public ItemGardenersCap(ArmorMaterial mat, int p_i45325_2_, int slot) {
		super(mat, p_i45325_2_, slot);
		setTextureName(ModInfo.ID + "itemGardenersCap");
		setUnlocalizedName("itemGardenersCap");
	}
	
	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return player.worldObj.isRaining() || player.worldObj.isThundering();
	}
}
