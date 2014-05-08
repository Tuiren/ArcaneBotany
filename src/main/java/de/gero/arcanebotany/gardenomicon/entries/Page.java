package de.gero.arcanebotany.gardenomicon.entries;

/**
 * @author Gero
 * 24.04.2014, 11:10:05 
 * 
 * Represents a page from an entry. Can have unlimted pages
 */
public class Page {
	
	private PageType type;

	public Page(PageType type) {
		this.type = type;
	}
	
	public PageType getPageType() {
		return type;
	}

}
