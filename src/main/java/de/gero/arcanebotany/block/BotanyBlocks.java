package de.gero.arcanebotany.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import de.gero.arcanebotany.block.block.BlockSilverwoodFence;
import de.gero.arcanebotany.block.flower.BlockGhastAmaryllis;
import de.gero.arcanebotany.block.flower.BlockGolemFern;
import de.gero.arcanebotany.block.flower.BlockNitorRoot;
import de.gero.arcanebotany.block.flower.BlockPurificationLotus;
import de.gero.arcanebotany.block.flower.BlockScribersPitcher;
import de.gero.arcanebotany.block.flower.BlockTaintedHedge;
import de.gero.arcanebotany.block.tile.TileGolemFern;
import de.gero.arcanebotany.block.tile.TilePurificationLotus;
import de.gero.arcanebotany.block.tile.TileTaintedHedge;

public class BotanyBlocks {

	public static Block scribers_pitcher;
	public static Block nitor_root;
	public static Block ghast_amaryllis;
	public static Block golem_fern;
	public static Block tainted_hedge;
	public static Block purification_lotus;
	
	public static Block silverwood_fence;

	public static void init() {
		scribers_pitcher = new BlockScribersPitcher(BlockInfo.SCRIBERS_PITCHER_ID);
		GameRegistry.registerBlock(scribers_pitcher, BlockInfo.SCRIBERS_PITCHER_KEY);
		
		nitor_root = new BlockNitorRoot(BlockInfo.NITOR_ROOT_ID);
		GameRegistry.registerBlock(nitor_root, BlockInfo.NITOR_ROOT_KEY);
		
		ghast_amaryllis = new BlockGhastAmaryllis(BlockInfo.GHAST_AMARYLLIS_ID);
		GameRegistry.registerBlock(ghast_amaryllis, BlockInfo.GHAST_AMARYLLIS_KEY);
		
		golem_fern = new BlockGolemFern();
		GameRegistry.registerBlock(golem_fern, "golem_fern");
		
		tainted_hedge = new BlockTaintedHedge(BlockInfo.TAINTED_HEDGE_ID);
		GameRegistry.registerBlock(tainted_hedge, BlockInfo.TAINTED_HEDGE_KEY);
		
		purification_lotus = new BlockPurificationLotus();
		GameRegistry.registerBlock(purification_lotus, "purification_lotus");

		registerTileEntities();
	}
	
	public static void preInit() {
		silverwood_fence = new BlockSilverwoodFence();
		GameRegistry.registerBlock(silverwood_fence, "silverwood_fence");
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileGolemFern.class, "tileGolemFern");
		GameRegistry.registerTileEntity(TileTaintedHedge.class, "tileTaintedHedge");
		GameRegistry.registerTileEntity(TilePurificationLotus.class, "tilePurificationLotus");
	}
}
