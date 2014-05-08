package de.gero.arcanebotany.block.tile;

import de.gero.arcanebotany.misc.ConfigValues;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.nodes.NodeType;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.tiles.TileNode;

/**
 * @author Gero
 * 26.04.2014, 20:21:54 
 *
 */
public class TilePurificationLotus extends TileEntity {

	@Override
	public boolean canUpdate(){
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("ticks", ticks);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.ticks = par1.getInteger("ticks");
	}
	
	TileNode repairing = null;
	int ticks = 0;
	int totalticks = ConfigValues.ticksForPurificationLotus;
	@Override
	public void updateEntity() {
		if(nodeThere()) {
			if(repairing == null) {
				repairing = selectNode();
			} else {
				ticks++;
				Thaumcraft.proxy.blockRunes(worldObj, xCoord, yCoord, zCoord, 235, 252, 48, 1, 0.001F/totalticks);
				if(ticks >= totalticks) {
					repairing.setNodeType(NodeType.NORMAL);
					worldObj.markBlockForUpdate(repairing.xCoord, repairing.yCoord, repairing.zCoord);
					worldObj.createExplosion((Entity) null, xCoord, yCoord, zCoord, 1F, false);
					worldObj.setBlockToAir(xCoord, yCoord, zCoord);
				}
			}
		} else {
			ticks = 0;
		}
	}
	
	public TileNode selectNode() {
		if(nodeThere()) {
			for (int x = -8; x <= 8; x++) {
				for (int y = -8; y <= 8; y++) {
					for (int z = -8; z <= 8; z++) {
						TileEntity te = worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z);
						if(te instanceof TileNode) {
							if(((TileNode) te).getNodeType().equals(NodeType.HUNGRY)){
								return (TileNode) te;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public boolean nodeThere() {
		for (int x = -8; x <= 8; x++) {
			for (int y = -8; y <= 8; y++) {
				for (int z = -8; z <= 8; z++) {
					TileEntity te = worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z);
					if(te instanceof TileNode) {
						if(((TileNode) te).getNodeType().equals(NodeType.HUNGRY)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	
	public String getProgress() {
		return "§3Progress: " + ((ConfigValues.ticksForPurificationLotus/20) - (ticks/20)) + " Seconds remeaning!";
	}
}
