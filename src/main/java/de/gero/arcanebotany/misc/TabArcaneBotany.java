package de.gero.arcanebotany.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.gero.arcanebotany.block.BotanyBlocks;

public class TabArcaneBotany extends CreativeTabs {

	public TabArcaneBotany(String label) {
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BotanyBlocks.tainted_hedge);
	}

}
