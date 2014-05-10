package de.gero.arcanebotany.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.gero.arcanebotany.misc.CapeImageBuffer;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		//TODO rendereres
	}

	//FIXME add supporters to the list/load supporters from a file in the interwebz!
	@Override
	public void addModderCapes() {
		String capeURL = "http://i.imgur.com/zbuangg.png";
		String[] devs = {"Empty2k12", "Laserlitschi"};

		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, new CapeImageBuffer());

		for (String username : devs) {

			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), image);

		}
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}