package de.gero.arcanebotany.block.tile;

import java.util.List;

import de.gero.arcanebotany.misc.ConfigValues;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.entities.golems.EntityGolemBase;
import thaumcraft.common.tiles.TileJarFillable;

/**
 * @author Gero
 * 25.04.2014, 18:55:59 
 *
 */
public class TileGolemFern extends TileEntity {

	//XXX make it IWandable to see time till next essentia suction?!

	@Override
	public boolean canUpdate(){
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("ticks", ticks);
		par1.setInteger("seconds", seconds);
		par1.setBoolean("canWork", canWork);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.ticks = par1.getInteger("ticks");
		this.seconds = par1.getInteger("seconds");
		this.canWork = par1.getBoolean("canWork");
	}

	private int ticks;
	private int seconds = ConfigValues.secondsTillGolemFernSucksNewEssentia;
	private boolean canWork;
	@Override
	public void updateEntity() {
		//TODO FIX THIS NAO!
		if(!getWorldObj().isRemote) {
			if(ConfigValues.secondsTillGolemFernSucksNewEssentia == -1) {
				canWork = true;
			} else {
				Boolean itTook = false;
				if(!itTook && takeEssentiaFromNearbyJar(Aspect.MOTION, 1, 10, this)) {
					itTook = true;
				}
				if(itTook) {
					ticks++;
					if(ticks % 20 == 0) {
						ticks = 0;
						seconds++;
						if(seconds == ConfigValues.secondsTillGolemFernSucksNewEssentia) {
							canWork = takeEssentiaFromNearbyJar(Aspect.MOTION, 1, 10, this);
							itTook = false;
						}
					}
				}
			}
			if(canWork) {
				final int range = 10;
				List<Entity> mobs = this.getWorldObj().getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(this.xCoord - range, this.yCoord - range, this.zCoord - range, this.xCoord + range, this.yCoord + range, this.zCoord + range));
				if(mobs.size() >= 1) {
					for(Entity mob : mobs) {
						if(mob instanceof EntityGolemBase) {
							((EntityGolemBase) mob).getActivePotionEffects().clear();
							((EntityGolemBase) mob).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 1, true));
						}
					}
				}
			}
		}
	}

	public boolean takeEssentiaFromNearbyJar(Aspect aspect, int amount, int searchRadius, TileEntity taking) {
		for(int xOffset = (-searchRadius); xOffset < searchRadius; xOffset++) {
			for(int yOffset = (-searchRadius); yOffset < searchRadius; yOffset++) {
				for(int zOffset = (-searchRadius); zOffset < searchRadius; zOffset++) {
					TileEntity te = taking.getWorldObj().getTileEntity(taking.xCoord + xOffset, taking.yCoord + yOffset, taking.zCoord + zOffset);
					if(te != null && te instanceof TileJarFillable) {
						TileJarFillable jar = (TileJarFillable) te;
						if(jar.doesContainerContainAmount(aspect, amount)) {
							Thaumcraft.proxy.essentiaTrailFx(worldObj, jar.xCoord, jar.yCoord, jar.zCoord, taking.xCoord, taking.yCoord, taking.zCoord, amount, aspect.getColor(), 1F);
							return true;
						} else {
							continue;
						}
					}
				}
			}
		}
		return false;
	}
}
