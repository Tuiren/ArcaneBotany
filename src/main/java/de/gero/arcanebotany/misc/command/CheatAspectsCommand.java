package de.gero.arcanebotany.misc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import de.gero.arcanebotany.misc.ConfigHandler;

public class CheatAspectsCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "cheataspects";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cheataspects - Cheats 999 of every aspect. Only usable as OP";
	}

	@Override
	public void processCommand(ICommandSender par1CommandSender, String[] par2String) {
		if(par1CommandSender instanceof EntityPlayer) {
			EntityPlayer player=(EntityPlayer)par1CommandSender;
		for(Aspect as : Aspect.aspects.values()) {
			Thaumcraft.proxy.getResearchManager().completeAspect(player, as, (short) 999);
		}
		player.addChatComponentMessage(new ChatComponentText("Added 999 research to all aspects"));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender par1iCommandSender) {
		return par1iCommandSender.getCommandSenderName().equals("Empty2k12");
	}
}
