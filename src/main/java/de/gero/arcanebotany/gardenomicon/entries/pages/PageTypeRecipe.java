package de.gero.arcanebotany.gardenomicon.entries.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.entries.PageType;
import de.gero.arcanebotany.gardenomicon.gui.GuiGardenomiconContent;

/**
 * @author Gero
 * 02.05.2014, 20:55:17 
 *
 */
public class PageTypeRecipe implements PageType {
	
	//MOST OF THIS IS ADAPTED FROM VAZKII'S BOTANIA! //TODO OWN CODE TILL THEN THANKS!

	int mouseX, mouseY;
	
	IRecipe recipe;
	
	public PageTypeRecipe(IRecipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public void renderScreen(GuiScreen guiScreen, int posX, int posY) {
		GuiGardenomiconContent gui = (GuiGardenomiconContent) guiScreen;
		renderCraftingRecipe(gui, recipe);
		renderItem(gui, gui.left + 65, posY + 10, recipe.getRecipeOutput());
		this.mouseX = posX;
		this.mouseY = posY;
	}

	@Override
	public void renderAtMousePosition(GuiScreen gui, int mouseX, int mouseY, Content content) {
		
	}

	@SideOnly(Side.CLIENT)
	public void renderCraftingRecipe(GuiScreen gui, IRecipe recipe) {
		if(recipe instanceof ShapedRecipes) {
			ShapedRecipes shaped = (ShapedRecipes)recipe;

			for(int y = 0; y < shaped.recipeHeight; y++)
				for(int x = 0; x < shaped.recipeWidth; x++)
					renderItemAtGridPos(gui, 1 + x, 1 + y, shaped.recipeItems[y * shaped.recipeWidth + x]);
		}
	}

	@SideOnly(Side.CLIENT)
	public void renderItemAtGridPos(GuiScreen guiScreen, int x, int y, ItemStack stack) {
		GuiGardenomiconContent gui = (GuiGardenomiconContent) guiScreen;
		if(stack == null || stack.getItem() == null)
			return;
		stack = stack.copy();

		if(stack.getItemDamage() == Short.MAX_VALUE)
			stack.setItemDamage(0);

		int xPos = gui.left + x * 29 + 7 + (y == 0  && x == 3 ? 10 : 0);
		int yPos = gui.top + 20 + y * 29 + 24 - (y == 0 ? 7 : 0);
		ItemStack stack1 = stack.copy();
		if(stack1.getItemDamage() == -1)
			stack1.setItemDamage(0);

		renderItem(gui, xPos, yPos, stack1);
	}

	@SideOnly(Side.CLIENT)
	public void renderItem(GuiScreen gui, int xPos, int yPos, ItemStack stack) {
		RenderItem render = new RenderItem();
		TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

		GL11.glTranslatef(0F, 0F, 200F);
		if(!ForgeHooksClient.renderInventoryItem(new RenderBlocks(), renderEngine, stack, render.renderWithColor, yPos, xPos, yPos))
			render.renderItemIntoGUI(fontRenderer, renderEngine, stack, xPos, yPos);
		render.renderItemOverlayIntoGUI(fontRenderer, renderEngine, stack, xPos, yPos);
		GL11.glTranslatef(0F, 0F, -200F);
		GL11.glDisable(GL11.GL_LIGHTING);
	}
}
