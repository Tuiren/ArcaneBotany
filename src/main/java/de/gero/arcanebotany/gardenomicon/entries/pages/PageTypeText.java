package de.gero.arcanebotany.gardenomicon.entries.pages;

import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.entries.PageType;
import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconContent;

/**
 * @author Gero
 * 24.04.2014, 11:18:29 
 *
 */
public class PageTypeText implements PageType {
	
	String text;

	public PageTypeText(String text) {
		this.text = text;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderScreen(GuiScreen guiScreen, int posX, int posY) {
		GuiGardenomiconContent gui = (GuiGardenomiconContent) guiScreen;
		boolean unicode = gui.getFontRenderer().getUnicodeFlag();
		gui.getFontRenderer().setUnicodeFlag(true);
		gui.getFontRenderer().drawSplitString(text, posX, posY, 110, 0);
		gui.getFontRenderer().setUnicodeFlag(unicode);
	}

	@Override
	public void renderAtMousePosition(GuiScreen gui, int mouseX, int mouseY, Content content) {
		//not needed here
	}

}
