package de.gero.arcanebotany.gardenomicon.misc.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconStart;

/**
 * @author Gero
 * 02.05.2014, 09:27:52 
 *
 */
public class ButtonContent extends GuiButton {

	private ItemStack stack;

	public ButtonContent(int id, int posX, int posY, int width, int height, String text, ItemStack stack) {
		super(id, posX, posY, width, height, text);
		this.stack = stack;
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int posX, int posY) {
		field_146123_n = posX >= xPosition && posY >= yPosition && posX < xPosition + width && posY < yPosition + height;
		int k = getHoverState(field_146123_n);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		boolean unicode = par1Minecraft.fontRenderer.getUnicodeFlag();
		par1Minecraft.fontRenderer.setUnicodeFlag(true);
		par1Minecraft.fontRenderer.drawString(k == 2 ? EnumChatFormatting.BOLD + displayString : displayString, xPosition + 22, yPosition + (height - 8) / 2, 0);
		par1Minecraft.fontRenderer.setUnicodeFlag(unicode);
		RenderItem render = new RenderItem();
		TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
		GL11.glTranslatef(0F, 0F, 200F);
		if(!ForgeHooksClient.renderInventoryItem(new RenderBlocks(), renderEngine, stack, render.renderWithColor, posY, posX, posY))
			render.renderItemIntoGUI(par1Minecraft.fontRenderer, renderEngine, stack, xPosition, yPosition);
		render.renderItemOverlayIntoGUI(par1Minecraft.fontRenderer, renderEngine, stack, xPosition, yPosition);
		GL11.glTranslatef(0F, 0F, -200F);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL11.GL_LIGHTING);
	}
}
