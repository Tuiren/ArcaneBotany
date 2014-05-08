package de.gero.arcanebotany.gardenomicon.entries;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * @author Gero
 * 24.04.2014, 11:08:21 
 *
 */
public class Content {
	
	String title;
	ItemStack item;
	
	List<Page> pages = new ArrayList<Page>();

	public Content(String title, ItemStack item) {
		this.title = title;
		this.item = item;
	}
	
	public Content addPage(Page page) {
		pages.add(page);
		return this;
	}
	
	public List<Page> getPages() {
		return pages;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ItemStack getItem() {
		return item;
	}

}
