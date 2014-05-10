package de.gero.arcanebotany.misc.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

/**
 * @author Gero
 * 26.04.2014, 13:02:13 
 *
 */

public class TaintedHedgeDamage extends DamageSource {
	
	//FIXME no chat messages shown
	
	public TaintedHedgeDamage() {
		super("taintedHedge");
	}
	
	public static DamageSource causeSwordDamage(Entity par0Entity, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("thedge", par0Entity, par1Entity));
	}
	
	@Override
	public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase) {
        return new ChatComponentText(par1EntityLivingBase + " decided to hug a Tainted Hedge!");
	}
}
