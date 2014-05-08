package de.gero.arcanebotany.misc;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.minecraft.client.renderer.IImageBuffer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CapeImageBuffer implements IImageBuffer {
	
	@Override
	public BufferedImage parseUserSkin(final BufferedImage texture)
	{
		if (texture == null)
			return null;
		int imageWidth = texture.getWidth(null) <= 64 ? 64 : texture.getWidth(null);
		int imageHeight = texture.getHeight(null) <= 32 ? 32 : texture.getHeight(null);

		BufferedImage capeImage = new BufferedImage(imageWidth, imageHeight, 2);

		Graphics graphics = capeImage.getGraphics();
		graphics.drawImage(texture, 0, 0, null);
		graphics.dispose();

		return capeImage;
	}
}
