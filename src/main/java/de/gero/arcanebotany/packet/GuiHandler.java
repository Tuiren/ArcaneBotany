package de.gero.arcanebotany.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.gardenomicon.gui.ContainerGardenomicon;
import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconStart;

/**
 * @author Gero
 * 24.04.2014, 08:16:15 
 *
 */
public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ArcaneBotany.instance, this);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		default: return null;
		case 0: return new GuiGardenomiconStart();
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		default: return null;
		case 0: return new ContainerGardenomicon(player);
		}
	}

}
