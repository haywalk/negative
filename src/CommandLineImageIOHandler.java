/*
 * CommandLineImageIOHandler.java
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

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Read and write BufferedImages to files specified in command-line
 * arguments.
 * 
 * @author Hayden Walker
 * @version 2021-03-26, modified 2022-04-13
 */
public class CommandLineImageIOHandler
{	
	// Store input and output file names
	private String inputFileName, outputFileName;
	// Store input and output file objecs
	private File inputFile, outputFile;
	
	/**
	 * Create a new CommandLineImageIOHandler object.
	 * 
	 * @param args Command-line arguments.
	 */
	public CommandLineImageIOHandler(String[] args)
	{
		// Get filename from arguments
		if(args.length >= 2) {
			// If user specified an input file and output file, use those
			inputFileName = args[0];
			outputFileName = args[1];
		} else if(args.length == 1) {
			// If user only specified input, overwrite it
			inputFileName = args[0];
			outputFileName = inputFileName;
		} else {
			// Otherwise, throw an error
			argumentError();
		}
		
		// Initialize file objects
		inputFile = new File(inputFileName);
		outputFile = new File(outputFileName);
	}
	
	/**
	 * Read and return the image.
	 * 
	 * @return BufferedImage read from location in arguments.
	 */
	public BufferedImage readFromInputFile() throws IOException
	{
		try {
			BufferedImage toRead = ImageIO.read(inputFile);
			return toRead;
		} catch(IOException e) {
			fileError();
		}
		
		return null;
	}
	
	/**
	 * Write a BufferedImage to an output file.
	 * 
	 * @param image Image to write.
	 */
	public void writeToOutputFile(BufferedImage image) throws IOException
	{
		ImageIO.write(image, "jpg", outputFile);
	}

	/**
	 * Show help message.
	 */
	private void help()
	{
		System.out.println("Usage: negative [inputfile.jpg] [outputfile.jpg]");
	}
	
	/**
	 * Show file error message.
	 */
	private void fileError()
	{
		System.out.println("Make sure that the specified input file exists.");
		help();
		System.exit(1);
	}
	
	/**
	 * Show argument error message.
	 */
	private void argumentError()
	{
		System.out.println("Invalid arguments");
		help();
		System.exit(1);
	}
}

