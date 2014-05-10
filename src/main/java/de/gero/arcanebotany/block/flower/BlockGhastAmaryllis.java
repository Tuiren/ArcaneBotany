package de.gero.arcanebotany.block.flower;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Gero
 * 25.04.2014, 09:14:27 
 *
 */
public class BlockGhastAmaryllis extends BlockFlower {
	
	//FIXME FINISH

	public BlockGhastAmaryllis(int id) {
		super(id);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockGhastAmaryllis");
		setBlockName("blockGhastAmaryllis");
		setHardness(0F);
		setStepSound(soundTypeGrass);
		setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.555F, 0.8F);
		setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		//FIXME: SOUNDS! world.playSoundEffect(x + 0.5D, y + 1, z + 0.5D, "mob.ghast.scream", 1.0F, 1.0F);
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
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockGhastAmaryllis");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}
}
