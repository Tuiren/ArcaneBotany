package de.gero.arcanebotany.block.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import de.gero.arcanebotany.ArcaneBotany;

/**
 * @author Gero
 * 26.04.2014, 11:54:01 
 *
 */
public class BlockSilverwoodFence extends BlockFence {
	
	//FIXME: Getting the texture after TC loads somehow

	public BlockSilverwoodFence() {
		super(new ResourceLocation("thaumcraft", "textures/blocks/planks_silverwood.png").getResourcePath(), Material.wood);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockName("blockSilverwoodFence");
	}

	public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		Block block = par1IBlockAccess.getBlock(par2, par3, par4);
        return block != this && block != Blocks.fence_gate ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
	}

}
