package de.gero.arcanebotany;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import de.gero.arcanebotany.block.BotanyBlocks;
import de.gero.arcanebotany.items.BotanyItems;
import de.gero.arcanebotany.misc.AspectHortus;
import de.gero.arcanebotany.misc.ConfigHandler;
import de.gero.arcanebotany.misc.ConfigValues;
import de.gero.arcanebotany.misc.EventHandlerWorld;
import de.gero.arcanebotany.misc.ModInfo;
import de.gero.arcanebotany.misc.TabArcaneBotany;
import de.gero.arcanebotany.misc.command.ChangeNodeCommand;
import de.gero.arcanebotany.misc.command.CheatAspectsCommand;
import de.gero.arcanebotany.packet.GuiHandler;
import de.gero.arcanebotany.packet.PacketPipeline;
import de.gero.arcanebotany.proxy.CommonProxy;
import de.gero.arcanebotany.research.BotanyCrafting;
import de.gero.arcanebotany.research.BotanyResearch;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class ArcaneBotany {

	@Instance(value = ModInfo.ID)
	public static ArcaneBotany instance;

	@SidedProxy(clientSide="de.gero.arcanebotany.proxy.ClientProxy", serverSide="de.gero.arcanebotany.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final PacketPipeline packetPipeline = new PacketPipeline();
	public static CreativeTabs tabBotany = new TabArcaneBotany("arcaneBotany");

	public static Aspect aspectHortus;
	
	/*
	 * TODO list
	 * setHarvestLevel("axe", 0); into Blocks that require it
	 * Connected Textures
	 * 
	 * */

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		BotanyItems.init();
		BotanyBlocks.init();
		BotanyCrafting.init();
	}

	@EventHandler
	public void initialise(FMLInitializationEvent evt) {
		if(ConfigValues.allowHortusAspect)
			aspectHortus = new AspectHortus("Hortus", 0x00C25E, new Aspect[] {Aspect.WATER, Aspect.VOID}, new ResourceLocation("arcanebotany", "textures/tabs/hortusAspect.png"), 771);

		packetPipeline.initialise();
		proxy.registerRenderers();
		proxy.addModderCapes();
		new GuiHandler();
		new EventHandlerWorld();
	}

	@EventHandler
	public void postInitialise(FMLPostInitializationEvent evt) {
		packetPipeline.postInitialise();
		BotanyResearch.init();
		BotanyBlocks.preInit();
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		((ServerCommandManager)MinecraftServer.getServer().getCommandManager()).registerCommand(new CheatAspectsCommand());
		((ServerCommandManager)MinecraftServer.getServer().getCommandManager()).registerCommand(new ChangeNodeCommand());
	}
}
