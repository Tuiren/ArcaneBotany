package de.gero.arcanebotany.block.tile;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import thaumcraft.common.entities.golems.EntityGolemBase;
import thaumcraft.common.entities.golems.EntityGolemBobber;

/**
 * @author Gero
 * 25.04.2014, 18:55:59 
 *
 */
public class TileGolemFern extends TileEntity {

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
