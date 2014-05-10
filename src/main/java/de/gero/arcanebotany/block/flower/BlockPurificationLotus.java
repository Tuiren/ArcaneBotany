package de.gero.arcanebotany.block.flower;

import java.awt.Color;
import java.util.List;

import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thaumcraft.api.wands.IWandable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.block.tile.TilePurificationLotus;
import de.gero.arcanebotany.misc.ModInfo;

/**
 * @author Gero
 * 26.04.2014, 14:54:52 
 *
 */
public class BlockPurificationLotus extends BlockLilyPad implements ITileEntityProvider, IWandable {

	public BlockPurificationLotus() {
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockPurificationLotus");
		setBlockName("blockPurificationLotus");
		setStepSound(soundTypeGrass);
	}
	
	//TODO FIXME colored texture instead of a gray one!
	@SideOnly(Side.CLIENT)
	@Override
	public int getBlockColor() {
		return new Color(255, 215, 0).getRGB();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderColor(int meta) {
		return new Color(255, 215, 0).getRGB();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int colorMultiplier(IBlockAccess acces, int x, int y, int z) {
		return new Color(255, 215, 0).getRGB();
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TilePurificationLotus();
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
		icon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockPurificationLotus");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}

	@Override
	public int onWandRightClick(World world, ItemStack wandstack, EntityPlayer player, int x, int y, int z, int side, int md) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TilePurificationLotus) {
			TilePurificationLotus lotus = (TilePurificationLotus) te;
			if(!world.isRemote) {
				player.addChatComponentMessage(new ChatComponentText(lotus.getProgress()));
			}
			return 0;
		}
		return 0;
	}

	@Override
	public ItemStack onWandRightClick(World world, ItemStack wandstack, EntityPlayer player) {
		return null;
	}

	@Override
	public void onUsingWandTick(ItemStack wandstack, EntityPlayer player, int count) {

	}

	@Override
	public void onWandStoppedUsing(ItemStack wandstack, World world, EntityPlayer player, int count) {

	}
}
