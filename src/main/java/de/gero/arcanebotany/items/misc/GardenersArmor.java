package de.gero.arcanebotany.items.misc;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import de.gero.arcanebotany.ArcaneBotany;
import de.gero.arcanebotany.misc.ModInfo;

/**
 * @author Gero
 *
 */
public class GardenersArmor extends ItemArmor implements IVisDiscountGear {

	static ArmorMaterial material = EnumHelper.addArmorMaterial("GardenersCloth", 0, new int[] { 2, 5, 3, 2 }, 20);

	public GardenersArmor(ArmorMaterial mat, int p_i45325_2_, int slot) {
		super(mat, p_i45325_2_, slot);

		setCreativeTab(ArcaneBotany.tabBotany);		
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? ModInfo.ID + ":textures/armor/gardenersCloth2.png" : ModInfo.ID + ":textures/armor/gardenersCloth1.png";
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
		return armorType == 3 ? 1 : 2;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("§3" + StatCollector.translateToLocal("tc.visdiscount") + ": " + (armorType == 3 ? 1 : 2) + "%");
	}


}
