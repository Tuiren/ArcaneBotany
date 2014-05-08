package de.gero.arcanebotany.gardenomicon.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.gardenomicon.data.GardenomiconData;
import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.misc.button.ButtonContent;
import de.gero.arcanebotany.gardenomicon.misc.button.ButtonImage;

/**
 * @author Gero
 * 24.04.2014, 07:40:44 
 *
 */
@SideOnly(Side.CLIENT)
public class GuiGardenomiconStart extends GuiScreen {

	public static final ResourceLocation texture = new ResourceLocation("arcanebotany", "textures/gui/gardenomicon.png");

	int guiWidth = 145;
	int guiHeight = 179;
	int left, top;

	int page = 1;
	int totalPages = 0;
	GuiButton bLeft, bRight;

	public static Content content;

	List<Content> allButtons = new ArrayList<Content>();

	public GuiGardenomiconStart() {

	}

	@Override
	public void initGui() {
		super.initGui();
		left = (width - guiWidth) / 2;
		top = (height - guiHeight) / 2;

		allButtons.clear();

		int addedPages = 0;
		for(GardenomiconData c : GardenomiconData.values()) {
			addedPages++;
			allButtons.add(c.getContent());
			
			if(addedPages % 5 == 0)
				totalPages++;
			
			System.out.println(totalPages);
		}
		
		//totalPages = (int)Math.ceil(allButtons.size() / 5);

		addButtons(page);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		drawDefaultBackground();
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		drawCenteredString(fontRendererObj, "Gardenomicon", left + 70, top + 15, 0x659D32);
		drawCenteredString(fontRendererObj, page + "/" + totalPages, left + 70, top + guiHeight - 5, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, f);
		drawToolTips(mouseX, mouseY);
	}

	public void addButtons(int pagee) {
		addNavigationButtons();
		int yoifn = 5;
		for(int a = 1; a < getButtonsForPage(page) + 2; a++) {
			yoifn--;
			this.buttonList.add(new ButtonContent(a, guiWidth + 15, 40 + (a * 20) + (a * 5), guiWidth - 30, 20, allButtons.get(page * 5 - yoifn - 1).getTitle(), allButtons.get(page * 5 - yoifn - 1).getItem()));
		}
	}

	public int getButtonsForPage(int page) {
		int b = 0;
		for(int a = 0; a < 5; a++) {
			if((allButtons.size() - a) % 5 == 0) {
				b = 5;
			} else {
				b = a;
			}
		}
		return b;
	}

	public void addNavigationButtons() {
		this.buttonList.clear();
		this.buttonList.add(bLeft = new ButtonImage(6, left, top + guiHeight - 10, 26, 207, 3, 207, 18, 10));
		this.buttonList.add(bRight = new ButtonImage(7, left + guiWidth - 18, top + guiHeight - 10, 26, 194, 3, 194, 18, 10));

		bLeft.enabled = page != 1;
		bRight.enabled = page != totalPages;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}	

	//this.buttonList.add(new ButtonContent(currentButton, guiWidth + 15, 40 + ((currentButton * 20) + (currentButton * 5)), guiWidth - 30, 20, allButtons.get((pagee * 5 - 5) + currentButton - 1).getTitle(), allButtons.get((pagee * 5 - 5) + currentButton - 1).getItem()));

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch(par1GuiButton.id) {
		case 6 :
			page--;
			addButtons(page);
			break;
		case 7 :
			page++;
			addButtons(page);
			break;
		default :
			Content entry = allButtons.get((page * 5 - 5) + par1GuiButton.id - 1);
			mc.displayGuiScreen(new GuiGardenomiconContent(entry, this));
		}
	}

	public void drawToolTips(int mouseX, int mouseY) {
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
}
