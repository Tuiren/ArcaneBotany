package de.gero.arcanebotany.misc;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.gero.arcanebotany.block.BotanyBlocks;

/**
 * @author Gero
 * 26.04.2014, 15:05:19 
 *
 */
public class EventHandlerWorld {

	public EventHandlerWorld() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	//FIXME just wanted to keep that for later tffs and things!
	//	@SubscribeEvent
	//	public void onLivingUpdateEvent(LivingUpdateEvent event) {
	//		if (event.entity instanceof EntityPlayer)
	//		{
	//			EntityPlayer player = (EntityPlayer) event.entity;
	//			ItemStack heldItem = player.getHeldItem();
	//			if (heldItem != null && heldItem.itemID == Item.arrow.itemID) {
	//				player.capabilities.allowFlying = true;
	//			}
	//			else {
	//				player.capabilities.allowFlying = player.capabilities.isCreativeMode ? true : false;
	//			}
	//		}
	//	}

	@SubscribeEvent
	public void onInteract(PlayerInteractEvent event) {
		if(event.action == Action.RIGHT_CLICK_BLOCK) {
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.water && event.entityPlayer.worldObj.isAirBlock(event.x, event.y + 1, event.z)) {
				if(event.face == 1) {
					if(event.entityPlayer.getCurrentEquippedItem() == new ItemStack(BotanyBlocks.purification_lotus)) {
						if(event.entityPlayer.getCurrentEquippedItem().stackSize == 1) {
							event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, null);
						} else {
							event.entityPlayer.getCurrentEquippedItem().stackSize--;
						}
					}
					event.entityPlayer.worldObj.setBlock(event.x, event.y + 1, event.z, BotanyBlocks.purification_lotus);
				}
			}
		}
	}
}
