package de.gero.arcanebotany.block.flower;

import java.util.List;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;

public class BlockNitorRoot extends BlockFlower {

	public BlockNitorRoot(int id) {
		super(id);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockNitorRoot");
		setBlockName("blockNitorRoot");
		setHardness(0F);
		setStepSound(soundTypeGrass);
		setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.555F, 0.8F);
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
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockNitorRoot");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}

	@Override
	public int getLightValue(IBlockAccess world,int  x,int y,int z){
		return 8;
	}
}
