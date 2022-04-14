/*
 * PixelPoke.java
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
import java.io.IOException;

/**
 * Make negatives of photos, whose locations are passed in as
 * command-line arguments.
 * 
 * Arguments are a mandatory input file (jpg) followed by an
 * optional output file (also jpg). If no output file is specified,
 * the program will overwrite the input file.
 * 
 * @author Hayden Walker
 * @version 2021-03-26, modified 2022-04-13
 */
public class PixelPoke
{
	/**
	 * Run the program.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) throws IOException
	{
		CommandLineImageIOHandler imgIO;
		InvertedBufferedImage negative;
		BufferedImage inputImage;
		BufferedImage outputImage;
		
		// Create new image IO handler
		imgIO = new CommandLineImageIOHandler(args);
		
		// Read input image
		inputImage = imgIO.readFromInputFile();
		
		// Create new negative from input image
		negative = new InvertedBufferedImage(inputImage);
		outputImage = negative.getImage();
		
		// Write negative to output file
		imgIO.writeToOutputFile(outputImage);
	}
}
