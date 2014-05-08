package de.gero.arcanebotany.block.tile;

import java.util.List;

import de.gero.arcanebotany.misc.damage.TaintedHedgeDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import thaumcraft.common.entities.golems.EntityGolemBase;
import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;

/**
 * @author Gero
 * 26.04.2014, 12:49:21 
 *
 */
public class TileTaintedHedge extends TileEntity {

	@Override
	public boolean canUpdate(){
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
	}

	@Override
	public void updateEntity() {

		//From TileNode Thanks Azanor!
		if (worldObj.getBiomeGenForCoordsBody(this.xCoord, this.yCoord) != ThaumcraftWorldGenerator.biomeTaint) {
			thaumcraft.common.lib.Utils.setBiomeAt(worldObj, this.xCoord, this.zCoord, ThaumcraftWorldGenerator.biomeTaint);
		}

		final int range = 10;

		List<IMob> mobs = this.getWorldObj().getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(this.xCoord - range, this.yCoord - range, this.zCoord - range, this.xCoord + range, this.yCoord + range, this.zCoord + range));
		if(mobs.size() >= 1) {
			for(IMob mob : mobs) {
				if(mob instanceof EntityLiving) {
					((EntityLiving) mob).attackEntityFrom(new TaintedHedgeDamage(), 1);
				}
			}
		}
	}
}
