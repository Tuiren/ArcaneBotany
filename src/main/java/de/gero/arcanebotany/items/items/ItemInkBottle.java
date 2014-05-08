/**
 * 
 */
package de.gero.arcanebotany.items.items;

import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * @author Gero
 *
 */
public class ItemInkBottle extends Item {

	public ItemInkBottle() {
		super();
		setCreativeTab(ArcaneBotany.tabBotany);
		setUnlocalizedName("bottleInk");
		setContainerItem(Items.glass_bottle);
		setTextureName(ModInfo.ID + ":" + "bottleInk");
		setFull3D();
	}

}
