package de.gero.arcanebotany.block.flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;

public class BlockScribersPitcher extends BlockFlower {

	public BlockScribersPitcher(int id) {
		super(id);
		setCreativeTab(ArcaneBotany.tabBotany);
		setBlockTextureName(ModInfo.ID + ":" + "blockScribersPitcher");
		setBlockName("blockScribersPitcher");
		setHardness(0F);
		setStepSound(soundTypeGrass);
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1, 0.8F);
		setTickRandomly(true);
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1));
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		switch(meta)
		{
		case 0:
			return;
		case 2:
			if(!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, 1, 0)));
			}
			return;
		}
		return;		
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 2) {
			return;
		}
		if (random.nextInt(2) != 0) {
			return;
		}
		world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
	}

	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[3];
		icons[0] = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockScribersPitcher0");
		icons[1] = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockScribersPitcher1");
		icons[2] = par1IconRegister.registerIcon(ModInfo.ID + ":" + "blockScribersPitcher2");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return icons[par2];
	}
}
