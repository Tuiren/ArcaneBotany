/**
 * 
 */
package de.gero.arcanebotany.research;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;

/**
 * @author Gero
 *
 */
public class BotanicResearchItem extends ResearchItem {


	public BotanicResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon) {
		super(key, category, tags, col, row, complex, icon);
	}

	public String getName()
	{
		return this.key;
	}

	public String getText()
	{
		return this.key;
	}

}
