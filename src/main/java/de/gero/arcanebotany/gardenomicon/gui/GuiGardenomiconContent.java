package de.gero.arcanebotany.gardenomicon.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.entries.Page;
import de.gero.arcanebotany.gardenomicon.misc.button.ButtonImage;

/**
 * @author Gero
 * 29.04.2014, 19:48:05 
 *
 */
public class GuiGardenomiconContent extends GuiScreen {

	List<Page> pages = new ArrayList<Page>();
	int page = 1;
	GuiButton bLeft, bRight, layerUp;

	public static final ResourceLocation texture = new ResourceLocation("arcanebotany", "textures/gui/gardenomicon.png");

	int guiWidth = 145;
	int guiHeight = 179;
	public int left, top;

	GuiGardenomiconStart gui;
	Content content;

	public GuiGardenomiconContent(Content content, GuiGardenomiconStart gui) {
		this.pages = content.getPages();
		this.gui = gui;
		this.content = content;
	}

	@Override
	public void initGui() {
		super.initGui();
		left = (width - guiWidth) / 2;
		top = (height - guiHeight) / 2;
		addNavigationButtons();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float par3) {
		drawDefaultBackground();
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		pages.get(page - 1).getPageType().renderScreen(this, left + 5, top + 30);
		drawCenteredString(fontRendererObj, content.getTitle(), left + 70, top + 15, 0x4f4f4f);
		drawCenteredString(fontRendererObj, page + "/" + content.getPages().size(), left + 70, top + guiHeight - 5, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, par3);
		drawToolTips(mouseX, mouseY);
		pages.get(page - 1).getPageType().renderAtMousePosition(this, mouseX, mouseY, content);
	}

	public void addNavigationButtons() {
		this.buttonList.clear();
		this.buttonList.add(bLeft = new ButtonImage(0, left, top + guiHeight - 10, 26, 207, 3, 207, 18, 10));
		this.buttonList.add(bRight = new ButtonImage(1, left + guiWidth - 18, top + guiHeight - 10, 26, 194, 3, 194, 18, 10));

		this.buttonList.add(layerUp = new ButtonImage(3, left - 17, top + 7, 26, 222, 3, 222, 20, 20));

		bLeft.enabled = page != 1;
		bRight.enabled = page < pages.size();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}	

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch(par1GuiButton.id) {
		case 0 :
			page--;
			break;
		case 1 :
			page++;
			break;
		case 3 : 
			mc.displayGuiScreen(gui);
			break;
		}
		addNavigationButtons();
	}

	public void drawToolTips(int mouseX, int mouseY) {
		if(layerUp.enabled) {
			if((mouseX > layerUp.xPosition) && (mouseX < layerUp.xPosition + layerUp.getButtonWidth())) {
				if((mouseY > layerUp.yPosition) && (mouseY < layerUp.yPosition + 20)) {
					this.drawString(mc.fontRenderer, "Back to menu", mouseX + 5, mouseY, 0xFFFFFF);
				}
			}
		}
		if(bLeft.enabled) {
			if((mouseX > bLeft.xPosition) && (mouseX < bLeft.xPosition + bLeft.getButtonWidth())) {
				if((mouseY > bLeft.yPosition) && (mouseY < bLeft.yPosition + 20)) {
					this.drawString(mc.fontRenderer, "Previous Page", mouseX + 5, mouseY, 0xFFFFFF);
				}
			}
		}
		if(bRight.enabled) {
			if((mouseX > bRight.xPosition) && (mouseX < bRight.xPosition + bRight.getButtonWidth())) {
				if((mouseY > bRight.yPosition) && (mouseY < bRight.yPosition + 20)) {
					this.drawString(mc.fontRenderer, "Next Page", mouseX + 5, mouseY, 0xFFFFFF);
				}
			}
		}
	}

	public FontRenderer getFontRenderer() {
		return fontRendererObj;
	}

	@SuppressWarnings("rawtypes")
	public void drawHoveringText(List list, int x, int y, FontRenderer fontrenderer)
	{
		if (!list.isEmpty())
		{
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			RenderHelper.disableStandardItemLighting();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			int k = 0;
			Iterator iterator = list.iterator();

			while (iterator.hasNext())
			{
				String s = (String) iterator.next();
				int l = fontrenderer.getStringWidth(s);

				if (l > k)
				{
					k = l;
				}
			}

			int i1 = x + 12;
			int j1 = y - 12;
			int k1 = 8;

			if (list.size() > 1)
			{
				k1 += 2 + (list.size() - 1) * 10;
			}

			this.zLevel = 300.0F;
			int l1 = -267386864;
			this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
			this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
			this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
			this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
			this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
			int i2 = 1347420415;
			int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
			this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
			this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
			this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
			this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

			for (int k2 = 0; k2 < list.size(); ++k2)
			{
				String s1 = (String) list.get(k2);
				fontrenderer.drawStringWithShadow(s1, i1, j1, -1);

				if (k2 == 0)
				{
					j1 += 2;
				}

				j1 += 10;
			}

			this.zLevel = 0.0F;
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			RenderHelper.enableStandardItemLighting();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}
	}
}
