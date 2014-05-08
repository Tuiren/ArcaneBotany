package de.gero.arcanebotany.items.items;

import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Gero
 * 24.04.2014, 08:00:45 
 *
 */
public class ItemGardenomicon extends Item {

	public ItemGardenomicon() {
		super();
		setCreativeTab(ArcaneBotany.tabBotany);
		setUnlocalizedName("gardenomicon");
		setTextureName(ModInfo.ID + ":" + "gardenomicon");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(!par3EntityPlayer.getEntityData().getBoolean("hasOpenedGardenomicon"))
			par3EntityPlayer.getEntityData().setBoolean("hasOpenedGardenomicon", true);
		
		par3EntityPlayer.openGui(ArcaneBotany.instance, 0, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
		return par1ItemStack;
	}

}
