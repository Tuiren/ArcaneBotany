package de.gero.arcanebotany.gardenomicon.data;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import de.gero.arcanebotany.block.BotanyBlocks;
import de.gero.arcanebotany.gardenomicon.entries.Content;
import de.gero.arcanebotany.gardenomicon.entries.Page;
import de.gero.arcanebotany.gardenomicon.entries.pages.PageTypeFactFile;
import de.gero.arcanebotany.gardenomicon.entries.pages.PageTypeRecipe;
import de.gero.arcanebotany.gardenomicon.entries.pages.PageTypeText;
import de.gero.arcanebotany.items.BotanyItems;
import de.gero.arcanebotany.research.BotanyCrafting;

/**
 * @author Gero
 * 24.04.2014, 07:41:56 
 *
 */
public enum GardenomiconData {
	
	//TODO data for all the things

	GARDENOMICON1(new Content(StatCollector.translateToLocal("item.gardenomicon.name"), new ItemStack(BotanyItems.gardenomicon))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.gardenomicon), StatCollector.translateToLocal("gardenomicon.gardenomicon.factfile.1"))))
	.addPage(new Page(new PageTypeRecipe(BotanyCrafting.gardenomicon)))),

	SCRIBERS_PITCHER2(new Content(StatCollector.translateToLocal("tile.blockScribersPitcher.name"), new ItemStack(BotanyBlocks.scribers_pitcher, 0, 3))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.scribers_pitcher, 3, 0), StatCollector.translateToLocal("gardenomicon.scribers_pitcher.factfile.1"))))),

	TAINTED_HEDGE3(new Content(StatCollector.translateToLocal("tile.blockTaintedHedge.name"), new ItemStack(BotanyBlocks.tainted_hedge))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.tainted_hedge), StatCollector.translateToLocal("gardenomicon.tainted_hedge.factfile.1"))))),

	NITOR_ROOT4(new Content(StatCollector.translateToLocal("tile.blockNitorRoot.name"), new ItemStack(BotanyBlocks.nitor_root))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.nitor_root), StatCollector.translateToLocal("gardenomicon.nitor_root.factfile.1"))))),

	PURIFICATION_LOTUS5(new Content(StatCollector.translateToLocal("tile.blockPurificationLotus.name"), new ItemStack(BotanyBlocks.purification_lotus))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.purification_lotus), StatCollector.translateToLocal("gardenomicon.purification_lotus.factfile.1"))))),

	GOLEM_FERN6(new Content(StatCollector.translateToLocal("tile.blockGolemFern.name"), new ItemStack(BotanyBlocks.golem_fern))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.golem_fern), StatCollector.translateToLocal("gardenomicon.golem_fern.factfile.1"))))),

	WATERING_FOCUS7(new Content(StatCollector.translateToLocal("item.focusWatering.name"), new ItemStack(BotanyItems.wand_focus_watering))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.wand_focus_watering), StatCollector.translateToLocal("gardenomicon.wand_focus_watering.factfile.1"))))),

	GARDENERS_CLOTH8(new Content(StatCollector.translateToLocal("gardeners_cloths.name"), new ItemStack(BotanyItems.gardeners_chest))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.gardeners_cap), StatCollector.translateToLocal("gardenomicon.gardeners_cap.factfile.1"))))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.gardeners_chest), StatCollector.translateToLocal("gardenomicon.gardeners_chest.factfile.1"))))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.gardeners_pants), StatCollector.translateToLocal("gardenomicon.gardeners_pants.factfile.1"))))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyItems.gardeners_boots), StatCollector.translateToLocal("gardenomicon.gardeners_boots.factfile.1"))))),

	GHAST_AMARYLLIS9(new Content(StatCollector.translateToLocal("tile.blockGhastAmaryllis.name"), new ItemStack(BotanyBlocks.ghast_amaryllis))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.ghast_amaryllis), StatCollector.translateToLocal("gardenomicon.ghast_amaryllis.factfile.1"))))),

	SILVERWOOD_FENCE10(new Content(StatCollector.translateToLocal("tile.blockSisrtlverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE11(new Content(StatCollector.translateToLocal("tile.blockSilverwoodhdfgdFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE12(new Content(StatCollector.translateToLocal("tile.blockSierlverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE13(new Content(StatCollector.translateToLocal("tile.blsdgockSilverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE14(new Content(StatCollector.translateToLocal("tile.bsgsfglockSilverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE15(new Content(StatCollector.translateToLocal("tile.bsgsfsrgglockSilverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE16(new Content(StatCollector.translateToLocal("tile.bsgsfrglockSilverwoodFence.name"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1"))))),

	SILVERWOOD_FENCE17(new Content(StatCollector.translateToLocal("tile.blsgsockSilverwoodFence.nameee"), new ItemStack(BotanyBlocks.silverwood_fence))
	.addPage(new Page(new PageTypeFactFile(new ItemStack(BotanyBlocks.silverwood_fence), StatCollector.translateToLocal("gardenomicon.silverwood_fence.factfile.1eee")))));

	GardenomiconData(Content content){
		this.content = content;
	}

	Content content;

	public Content getContent(){
		return content;
	}
}
