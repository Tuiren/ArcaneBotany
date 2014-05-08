package de.gero.arcanebotany.research;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigResearch;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.block.BotanyBlocks;
import de.gero.arcanebotany.items.BotanyItems;
import de.gero.arcanebotany.misc.ModInfo;

/**
 * @author Gero
 * 23.04.2014, 10:02:04 
 *
 */
public class BotanyResearch {

	public static void init(){
		addPage();
		addAspects();
		addArcaneRecipes();
		addResearch();
	}

	private static void addResearch() {
		new BotanicResearchItem("Arcane Botany",
				"ArcaneBotany",
				new AspectList(),
				0,
				0,
				0,
				new ItemStack(Blocks.acacia_stairs, 1, 0)).setPages(new ResearchPage("//TODO ADD INFO"))
				.setStub().setRound().setAutoUnlock().registerResearchItem();
		
		new BotanicResearchItem("Gardenomicon",
				"ArcaneBotany",
				new AspectList().add(Aspect.TOOL, 5).add(Aspect.AIR, 5),
				3,
				4,
				0,
				new ItemStack(BotanyItems.gardenomicon)).setPages(new ResearchPage[] {new ResearchPage((ShapelessArcaneRecipe)ConfigResearch.recipes.get("Gardenomicon"))
				}).setConcealed().registerResearchItem();
	}
	
	public static void addArcaneRecipes(){
		ConfigResearch.recipes.put("Gardenomicon", ThaumcraftApi.addShapelessArcaneCraftingRecipe("Gardenomicon", new ItemStack(BotanyItems.gardenomicon, 1, 0), new AspectList().add(Aspect.WATER, 5), new Object[] {Items.book, BotanyItems.inkBottle}));
	}

	private static void addAspects(){
		//Items
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.wand_focus_watering), new int[]{0}, new AspectList().add(Aspect.WATER, 10).add(Aspect.MAGIC, 5).add(Aspect.CROP, 3));
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.gardeners_cap), new int[]{0}, new AspectList().add(Aspect.ARMOR, 5).add(ArcaneBotany.aspectHortus, 5).add(Aspect.PLANT, 2));
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.gardeners_chest), new int[]{0}, new AspectList().add(Aspect.ARMOR, 5).add(ArcaneBotany.aspectHortus, 5).add(Aspect.PLANT, 2));
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.gardeners_pants), new int[]{0}, new AspectList().add(Aspect.ARMOR, 5).add(ArcaneBotany.aspectHortus, 5).add(Aspect.PLANT, 2));
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.gardeners_boots), new int[]{0}, new AspectList().add(Aspect.ARMOR, 5).add(ArcaneBotany.aspectHortus, 5).add(Aspect.PLANT, 2));

		ThaumcraftApi.registerObjectTag(ii(BotanyItems.gardenomicon), new int[]{0}, new AspectList().add(Aspect.CLOTH, 5).add(ArcaneBotany.aspectHortus, 5).add(Aspect.CRAFT, 2).add(Aspect.PLANT, 3));
		ThaumcraftApi.registerObjectTag(ii(BotanyItems.inkBottle), new int[]{0}, new AspectList().add(Aspect.WATER, 1).add(ArcaneBotany.aspectHortus, 1));

		//Blocks
		ThaumcraftApi.registerObjectTag(ib(BotanyBlocks.scribers_pitcher), new int[]{0}, new AspectList().add(Aspect.DARKNESS, 5).add(Aspect.PLANT, 5).add(ArcaneBotany.aspectHortus, 2));
		ThaumcraftApi.registerObjectTag(ib(BotanyBlocks.nitor_root), new int[]{0}, new AspectList().add(Aspect.LIGHT, 5).add(Aspect.PLANT, 5).add(ArcaneBotany.aspectHortus, 2));
		ThaumcraftApi.registerObjectTag(ib(BotanyBlocks.golem_fern), new int[]{0}, new AspectList().add(Aspect.TRAVEL, 5).add(Aspect.CRYSTAL, 2).add(ArcaneBotany.aspectHortus, 2));
		ThaumcraftApi.registerObjectTag(ib(BotanyBlocks.tainted_hedge), new int[]{0}, new AspectList().add(Aspect.AURA, 5).add(Aspect.DARKNESS, 2).add(ArcaneBotany.aspectHortus, 2));
		ThaumcraftApi.registerObjectTag(ib(BotanyBlocks.ghast_amaryllis), new int[]{0}, new AspectList().add(Aspect.BEAST, 5).add(Aspect.SENSES, 2).add(ArcaneBotany.aspectHortus, 2));
	}

	private static void addPage(){
		ResearchCategories.registerCategory("ArcaneBotany", new ResourceLocation(ModInfo.ID + "textures/tabs/hortusAspect.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
	}

	public static ItemStack ii(Item item){
		return new ItemStack(item, 1);
	}

	public static ItemStack ib(Block block){
		return new ItemStack(block, 1);
	}



}
