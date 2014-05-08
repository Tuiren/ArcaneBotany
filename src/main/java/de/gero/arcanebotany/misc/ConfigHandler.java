package de.gero.arcanebotany.misc;

import java.io.File;

import de.gero.arcanebotany.block.BlockInfo;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static void init(File file) {
		
		Configuration config = new Configuration(file);
		
		config.load();
		
		//Blocks
		BlockInfo.SCRIBERS_PITCHER_ID = config.get("Blocks", "Scribers Pitcher ID:", BlockInfo.SCRIBERS_PITCHER_DEFAULT).getInt();
		BlockInfo.NITOR_ROOT_ID = config.get("Blocks", "Nitor Root ID:", BlockInfo.NITOR_ROOT_DEFAULT).getInt();
		BlockInfo.GHAST_AMARYLLIS_ID = config.get("Blocks", "Ghast Amayllis ID:", BlockInfo.GHAST_AMARYLLIS_DEFAULT).getInt();
		BlockInfo.TAINTED_HEDGE_ID = config.get("Blocks", "Tainted Hedge ID:", BlockInfo.TAINTED_HEDGE_KEY).getInt();
		
		//Booleans
		ConfigValues.allowHortusAspect = config.get("Miscellaneous", "Allow Hortus(Garden) Aspect:", true).getBoolean(true);
		ConfigValues.ticksForPurificationLotus = config.get("Miscellaneous", "Ticks for the Purification Lotus to repair the Node:", 12000).getInt();
		
		config.save();
	}

}
