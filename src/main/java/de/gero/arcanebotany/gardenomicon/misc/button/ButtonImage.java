package de.gero.arcanebotany.gardenomicon.misc.button;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconStart;

public class ButtonImage extends GuiButton {
	
	int hoveredX;
	int hoveredY;
	
	int normalX;
	int normalY;
	
	int buttonWidth;
	int buttonHeight;
	

	public ButtonImage(int id, int posX, int posY, int hoveredX, int hoveredY, int normalX, int normalY, int buttonWidth, int buttonHeight) {
		super(id, posX, posY, buttonWidth, buttonHeight, "");
		this.hoveredX = hoveredX;
		this.hoveredY = hoveredY;
		
		this.normalX = normalX;
		this.normalY = normalY;
		
		this.buttonHeight = buttonHeight;
		this.buttonWidth = buttonWidth;
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int posX, int posY) {
		if(enabled) {
			field_146123_n = posX >= xPosition && posY >= yPosition && posX < xPosition + width && posY < yPosition + height;
			int k = getHoverState(field_146123_n);

			par1Minecraft.renderEngine.bindTexture(GuiGardenomiconStart.texture);
			GL11.glColor4f(1F, 1F, 1F, 1F);
			drawTexturedModalRect(xPosition, yPosition, k == 2 ? hoveredX : normalX, k == 2 ? hoveredY : normalY, buttonWidth, buttonHeight);
		}
	}

}