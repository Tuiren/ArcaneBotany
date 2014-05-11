package de.gero.arcanebotany.misc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import thaumcraft.api.nodes.NodeModifier;
import thaumcraft.api.nodes.NodeType;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.tiles.TileJarNode;

/**
 * @author Gero
 * 23.04.2014, 13:54:33 
 *
 */

public class ChangeNodeCommand extends CommandBase {

	//TODO localisation

	@Override
	public String getCommandName() {
		return "changenode";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/changenode [type] - Changes a Node in a Jar. Only usable as OP";
	}

	//TODO better handling
	@Override
	public void processCommand(ICommandSender par1CommandSender, String[] par2String) {
		if(par1CommandSender instanceof EntityPlayer && par2String.length == 1) {
			EntityPlayer player=(EntityPlayer)par1CommandSender;
			for(int x = -3; x < 5; x++){
				for(int y = -3; y < 5; y++){
					for(int z = -3; z < 5; z++){
						TileEntity te = player.worldObj.getTileEntity((int)player.posX + x, (int)player.posY + y, (int)player.posZ + z);
						if(te instanceof TileJarNode){
							TileJarNode jar = (TileJarNode) te;
							if(par2String[0].equals("reset")){
								jar.setNodeModifier(null);
								jar.setNodeType(NodeType.NORMAL);
							} else if(par2String[0].equals("unstable")) {
								jar.setNodeType(NodeType.UNSTABLE);
							} else if(par2String[0].equals("dark")) {
								jar.setNodeType(NodeType.DARK);
							} else if(par2String[0].equals("tainted")) {
								jar.setNodeType(NodeType.TAINTED);
							} else if(par2String[0].equals("hungry")) {
								jar.setNodeType(NodeType.HUNGRY);
							} else if(par2String[0].equals("pure")) {
								jar.setNodeType(NodeType.PURE);
							} else if(par2String[0].equals("bright")) {
								jar.setNodeModifier(NodeModifier.BRIGHT);
							} else if(par2String[0].equals("pale")) {
								jar.setNodeModifier(NodeModifier.PALE);
							} else if(par2String[0].equals("fading")) {
								jar.setNodeModifier(NodeModifier.FADING);
							} else {
								player.addChatComponentMessage(new ChatComponentText("Invalid Argument: " + par2String[0]));
								break;
							}
							player.addChatComponentMessage(new ChatComponentText(output(jar)));
							player.worldObj.markBlockForUpdate(jar.xCoord, jar.yCoord, jar.zCoord);
						}
					}
				}
			}
		} else {
			//TODO FEHLER/CONSOLE
		}
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	private String output(TileJarNode jar){
		return jar.getNodeModifier() == null ? "Changed Node: " + jar.getNodeType().toString().toUpperCase() : "Changed Node: " + jar.getNodeType().toString().toUpperCase() + " , " + jar.getNodeModifier().toString().toUpperCase();
	}


}

