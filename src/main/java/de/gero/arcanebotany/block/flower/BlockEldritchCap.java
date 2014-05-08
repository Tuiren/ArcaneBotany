package de.gero.arcanebotany.block.flower;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

/**
 * @author Gero
 * 25.04.2014, 09:36:25 
 *
 */
public class BlockEldritchCap extends BlockBush implements IGrowable {

	public BlockEldritchCap() {
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockEldritchCap");
		setBlockName("blockEldritchCap");
		setStepSound(soundTypeGrass);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setTickRandomly(true);
	}

	@Override
	public boolean func_149851_a(World var1, int var2, int var3, int var4, boolean var5) {
		return true;
	}

	@Override
	public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5) {
		return (double)var2.nextFloat() < 0.4D;
	}

	@Override
	public void func_149853_b(World var1, Random var2, int var3, int var4, int var5) {
		//this.func_149884_c(var1, var2, var3, var4, var5);
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
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockEldritchCap");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}

}
