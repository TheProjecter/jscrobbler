package org.jmayorga.jscrobbler.util;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImageUtil {
	private static final Log log = LogFactory.getLog(ImageUtil.class);

	public static void saveImage(String name, String imageLocation) {
		try {
			log.debug("Saving image: [" + imageLocation + "]");
			String ext = imageLocation.substring(imageLocation.length() - 3);
			// Create a URL for the image's location
			URL url = new URL(imageLocation);

			// Get the image
			Image image = ImageIO.read(url);

			ImageIO.write((RenderedImage) image, ext,
					new File(name + "." + ext));

		} catch (MalformedURLException e) {
			log.error("MalformedURLException, ", e);
		} catch (IOException e) {
			log.error("IOException, ", e);
		}
	}

}
