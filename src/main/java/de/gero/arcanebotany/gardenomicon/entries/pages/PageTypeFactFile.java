package de.gero.arcanebotany.gardenomicon.entries.pages;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.entries.PageType;
import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconContent;

/**
 * @author Gero
 * 02.05.2014, 10:01:38 
 *
 */
public class PageTypeFactFile implements PageType {

	String facts;
	ItemStack stack;

	public PageTypeFactFile(ItemStack stack, String facts) {
		this.stack = stack;
		this.facts = facts;
	}

	@Override
	public void renderScreen(GuiScreen guiScreen, int posX, int posY) {
		RenderItem render = new RenderItem();
		TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		GL11.glTranslatef(0F, 0F, 200F);
		if(!ForgeHooksClient.renderInventoryItem(new RenderBlocks(), renderEngine, stack, render.renderWithColor, posY, posX, posY))
			render.renderItemIntoGUI(fontRenderer, renderEngine, stack, posX + 55, posY);
		render.renderItemOverlayIntoGUI(fontRenderer, renderEngine, stack, posX + 55, posY);
		GL11.glTranslatef(0F, 0F, -200F);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL11.GL_LIGHTING);

		GuiGardenomiconContent gui = (GuiGardenomiconContent) guiScreen;
		boolean unicode = gui.getFontRenderer().getUnicodeFlag();
		gui.getFontRenderer().setUnicodeFlag(true);
		gui.getFontRenderer().drawSplitString(facts, posX + 15, posY + 20, 110, 0);
		gui.getFontRenderer().setUnicodeFlag(unicode);
	}

	@Override
	public void renderAtMousePosition(GuiScreen guiScreen, int mouseX, int mouseY, Content content) {
		GuiGardenomiconContent gui = (GuiGardenomiconContent) guiScreen;
		if(mouseX >= gui.left + 65 && mouseX <= gui.left + 65 + 16) {
			if(mouseY >= gui.top + 30 && mouseY <= gui.top + 30 + 16) {
				gui.drawHoveringText(Arrays.asList(content.getItem().getRarity().rarityColor + content.getItem().getDisplayName()), mouseX, mouseY, Minecraft.getMinecraft().fontRenderer);
			}
		}
	}

}
