package de.gero.arcanebotany.block.flower;

import java.util.List;

import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.block.tile.TileGolemFern;
import de.gero.arcanebotany.misc.ModInfo;

/**
 * @author Gero
 * 25.04.2014, 09:35:30 
 *
 */
public class BlockGolemFern extends BlockBush implements ITileEntityProvider {

	//TODO FIXME use essentia from nearby jar

	public BlockGolemFern() {
		super(Material.vine);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockGolemFern");
		setBlockName("blockGolemFern");
		setStepSound(soundTypeGrass);
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
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockGolemFern");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}

	
	//FIXME colors in the inventory or colored texture instead of a gray one
	public int getBlockColor() {
		return 0x000000;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_) {
		return this.getBlockColor();
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
		return 0xA52A2A;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileGolemFern();
	}
}
