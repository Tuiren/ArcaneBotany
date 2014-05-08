/**
 * 
 */
package de.gero.arcanebotany.items.misc;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

/**
 * @author Gero
 *
 */
public class ItemGardenersBoots extends GardenersArmor {

	public ItemGardenersBoots(ArmorMaterial mat, int p_i45325_2_, int slot) {
		super(mat, p_i45325_2_, slot);
		setTextureName(ModInfo.ID + "itemGardenersBoots");
		setUnlocalizedName("itemGardenersBoots");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;

			ItemStack armor = player.getCurrentArmor(3 - armorType);
			if(armor != null && armor.getItem() == this) {
				if(player.worldObj.isRemote)
					player.stepHeight = player.isSneaking() ? 0.5F : 1F;
			} else {
				player.stepHeight = 0.5F;
			}
		}
	}
}
