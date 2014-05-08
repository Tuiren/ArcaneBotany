package de.gero.arcanebotany.items.foci;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus.WandFocusAnimation;
import thaumcraft.api.wands.ItemFocusBasic;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;

public class ItemFocusFlight extends ItemFocusBasic {

	private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 15);

	public ItemFocusFlight(int i) {
		super();
		setCreativeTab(ArcaneBotany.tabBotany);
		setTextureName(ModInfo.ID + ":" + "itemFocusFlight");
		setUnlocalizedName("focusFlight");
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer p, MovingObjectPosition movingobjectposition) {
		Vec3 vec = p.getLookVec();
		double force = 1 / 1.5 * 2;
		p.motionX = vec.xCoord * force;
		p.motionY = vec.yCoord * force;
		p.motionZ = vec.zCoord * force;
		p.fallDistance = 0F;

		world.playSoundAtEntity(p, "thaumcraft:wind", 0.4F, 1F);

		if(world.isRemote)
			p.swingItem();

		return itemstack;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "FLIGHT";
	}

	@Override
	public int getFocusColor() {
		return 0x9EF2FF;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisCostPerTick() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player,
			int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world,
			EntityPlayer player, int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFocusBlockStartBreak(ItemStack itemstack, int x, int y,
			int z, EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptsEnchant(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
