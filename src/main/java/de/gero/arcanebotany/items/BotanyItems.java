package de.gero.arcanebotany.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.items.baubles.ItemRingofTheGardener;
import de.gero.arcanebotany.items.foci.ItemFocusWatering;
import de.gero.arcanebotany.items.items.ItemGardenomicon;
import de.gero.arcanebotany.items.items.ItemInkBottle;
import de.gero.arcanebotany.items.misc.ItemGardenersBoots;
import de.gero.arcanebotany.items.misc.ItemGardenersCap;
import de.gero.arcanebotany.items.misc.ItemGardenersChest;
import de.gero.arcanebotany.items.misc.ItemGardenersPants;

public class BotanyItems {
	
	public static Item wand_focus_watering;
	
	public static Item gardeners_cap;
	public static Item gardeners_chest;
	public static Item gardeners_pants;
	public static Item gardeners_boots;
	
	public static Item gardenomicon;
	public static Item inkBottle;

	public static Item ringofTheGardener;
	
	public static void init(){
		wand_focus_watering = new ItemFocusWatering();
		GameRegistry.registerItem(wand_focus_watering, "focus_watering");
		
		gardeners_cap = new ItemGardenersCap(ArmorMaterial.CHAIN, ArcaneBotany.proxy.addArmor("gardenersArmor"), 0);
		GameRegistry.registerItem(gardeners_cap, "gardeners_cap");
		
		gardeners_chest = new ItemGardenersChest(ArmorMaterial.CHAIN, ArcaneBotany.proxy.addArmor("gardenersArmor"), 1);
		GameRegistry.registerItem(gardeners_chest, "gardeners_chest");
		
		gardeners_pants = new ItemGardenersPants(ArmorMaterial.CHAIN, ArcaneBotany.proxy.addArmor("gardenersArmor"), 2);
		GameRegistry.registerItem(gardeners_pants, "gardeners_pants");
		
		gardeners_boots = new ItemGardenersBoots(ArmorMaterial.CHAIN, ArcaneBotany.proxy.addArmor("gardenersArmor"), 3);
		GameRegistry.registerItem(gardeners_boots, "gardeners_boots");
		
		gardenomicon = new ItemGardenomicon();
		GameRegistry.registerItem(gardenomicon, "gardenomicon");
		
		inkBottle = new ItemInkBottle();
		GameRegistry.registerItem(inkBottle, "inkBottle");
		
		ringofTheGardener = new ItemRingofTheGardener();
		GameRegistry.registerItem(ringofTheGardener, "ringofTheGardener");
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ringofTheGardener, 1, 0), 1, 1, 35));
		
		registerOreDictionaryNames();
	}
	
	public static void registerOreDictionaryNames(){
		OreDictionary.registerOre("dyeBlack", inkBottle);
	}

}
