package de.gero.arcanebotany.gardenomicon.entries;

import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Gero
 * 24.04.2014, 11:12:19 
 *
 */
public interface PageType {
	
	@SideOnly(Side.CLIENT)
	public void renderScreen(GuiScreen gui, int posX, int posY);
	
	@SideOnly(Side.CLIENT)
	public void renderAtMousePosition(GuiScreen gui, int mouseX, int mouseY, Content content);

}
