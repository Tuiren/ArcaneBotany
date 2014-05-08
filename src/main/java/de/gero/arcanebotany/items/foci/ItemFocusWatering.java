package de.gero.arcanebotany.items.foci;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;

public class ItemFocusWatering extends ItemFocusBasic {

	private static final AspectList visUsage = new AspectList().add(Aspect.WATER, 3);

	public ItemFocusWatering() {
		super();
		setCreativeTab(ArcaneBotany.tabBotany);
		setTextureName(ModInfo.ID + ":" + "itemFocusWatering");
		setUnlocalizedName("focusWatering");
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack wand, World world, EntityPlayer p, MovingObjectPosition movingobjectposition) {
		boolean success = false;
		if(ThaumcraftApiHelper.consumeVisFromWand(wand, p, visUsage, false, false)){
			int xCoord = p.rayTrace(5, 1F).blockX;
			int yCoord = p.rayTrace(5, 1F).blockY;
			int zCoord = p.rayTrace(5, 1F).blockZ;

			final int x = selectFromRange(3, world) + xCoord;
			final int z = selectFromRange(3, world) + zCoord;

			if(world.getBlock(xCoord, yCoord, zCoord) == Blocks.farmland){
				int basemeta = world.getBlockMetadata(xCoord,  yCoord,  zCoord);
				if (basemeta >= 7){
					world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, basemeta + 1, 2);
					success = true;
				}
			}

			if(world.rand.nextDouble() < 1F / 30) {
				if (ItemDye.applyBonemeal(new ItemStack(Items.dye, 1, 15), world, x, yCoord, z, p)) {
					success = true;
				}
			}
			
			if(success){
				ThaumcraftApiHelper.consumeVisFromWand(wand, p, visUsage, true, false);
				if(world.isRemote)
					p.swingItem();
			}
		}
		return wand;
	}

	private static int selectFromRange(int range, World world) {
		return world.rand.nextInt(2 * range + 1) - range;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "WATERING";
	}

	@Override
	public int getFocusColor() {
		return 0x4B69E3;
	}

	@Override
	public AspectList getVisCost() {
		return visUsage;
	}

	@Override
	public IIcon getFocusDepthLayerIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IIcon getOrnament() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WandFocusAnimation getAnimation() {
		return WandFocusAnimation.WAVE;
	}

	@Override
	public boolean isVisCostPerTick() {
		return false;
	}

	@Override
	public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int count) {

	}

	@Override
	public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world, EntityPlayer player, int count) {

	}

	@Override
	public boolean onFocusBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		return false;
	}

	@Override
	public boolean acceptsEnchant(int id) {
		return true; //TODO make entchantes better
	}
}
