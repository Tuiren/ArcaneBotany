package de.gero.arcanebotany.research;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import de.gero.arcanebotany.items.BotanyItems;

/**
 * @author Gero
 * 02.05.2014, 21:23:01 
 *
 */
public class BotanyCrafting {
	
	public static IRecipe gardenomicon;
	public static IRecipe cobble;

	public static void init() {
		gardenomicon = GameRegistry.addShapedRecipe(new ItemStack(BotanyItems.gardenomicon), "x", "y", 'x', new ItemStack(Items.book), 'y', new ItemStack(BotanyItems.inkBottle));
		cobble = GameRegistry.addShapedRecipe(new ItemStack(Blocks.cobblestone), "xxx", "xxx", "xxx", 'x', new ItemStack(Blocks.cobblestone));
	}

}
