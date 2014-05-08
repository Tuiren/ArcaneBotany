package de.gero.arcanebotany.gardenomicon.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author Gero
 * 24.04.2014, 08:19:13 
 *
 */
public class ContainerGardenomicon extends Container {

	public ContainerGardenomicon(EntityPlayer player) {
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
