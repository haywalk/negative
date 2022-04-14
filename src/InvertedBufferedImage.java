/*
 * InvertedBufferedImage.java
 * 
 * Copyright 2021-2022 Hayden D. Walker <haydenwalker@live.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.awt.image.BufferedImage;

/**
 * An inverted BufferedImage. Final project for
 * AP Computer Science Principles.
 * 
 * @author Hayden Walker
 * @version 2021-03-26, modified 2022-04-13
 */
public class InvertedBufferedImage
{
	// BufferedImage to be inverted
	private BufferedImage img;
	
	/**
	 * Create a new InvertedImage object.
	 * 
	 * @param img Image to invert.
	 */
	public InvertedBufferedImage(BufferedImage img)
	{
		this.img = img;
		makeNegative();
	}
	
	/**
	 * Take in a BufferedImage and invert its colours.
	 * 
	 * @param img Image to invert.
	 */
	private void makeNegative()
	{
		// Get the dimensions of the image
		int width = img.getWidth();
		int height = img.getHeight();
		
		// Iterate through each row of the image
		for(int row = 0; row < height; row++) {
			// Iterate through each column
			for(int column = 0; column < width; column++){
				// Invert each pixel by subtracting its current colour value from that of white
				img.setRGB(column, row, 0xFFFFFF - img.getRGB(column, row));
			}
		}
	}
	
	/**
	 * Return the inverted image.
	 * 
	 * @return The inverted image.
	 */
	public BufferedImage getImage()
	{
		return img;
	}
}
