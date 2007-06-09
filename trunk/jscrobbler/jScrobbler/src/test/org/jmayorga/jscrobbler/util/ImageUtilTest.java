package org.jmayorga.jscrobbler.util;

import java.io.File;

import junit.framework.TestCase;

public class ImageUtilTest extends TestCase {
	public void testSaveImage() {
		ImageUtil.saveImage("test",
				"http://panther1.last.fm/coverart/130x130/1411810.jpg");
		assertNotNull(new File("test.jpg"));
	}
}
