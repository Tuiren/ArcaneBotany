package de.gero.arcanebotany.block.flower;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.block.tile.TileTaintedHedge;
import de.gero.arcanebotany.misc.ModInfo;

/**
 * @author Gero
 * 25.04.2014, 09:31:53 
 *
 */
public class BlockTaintedHedge extends BlockFlower implements ITileEntityProvider{

	//When planted in a tainted biome thers a chance that the flower mutates into the tainted hedge which then can be harvested and used everywhere. When using it in a non taint biome it will slowly turn the biome into a tainted biome. Can be prevented with a pure node.

	public BlockTaintedHedge(int id) {
		super(id);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockTaintedHedge");
		setBlockName("blockTaintedHedge");
		setHardness(0F);
		setStepSound(soundTypeGrass);
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1, 0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileTaintedHedge();
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1));
	}

	@SideOnly(Side.CLIENT)
	public static IIcon icon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockTaintedHedge");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}
}
