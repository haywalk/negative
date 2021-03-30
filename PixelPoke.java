/*
 * PixelPoke by Hayden Walker, for the AP Computer Science Principles final project
 * 26 March 2021
 */

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class PixelPoke {
	public static void main(String[] args) throws IOException {
		// Create variables to store names of input and output files
		String inputFileName = "";
		String outputFileName = "";

		// Get filename from arguments
		if(args.length == 2) {
			// If user specified an input file and output file, use those
			inputFileName = args[0];
			outputFileName = args[1];
		} else if(args.length == 1) {
			// If user only specified input, overwrite it.
			inputFileName = args[0];
			outputFileName = inputFileName;
		} else {
			inputError();
		}
		
		// Create input and output files
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		
		// Create a new buffered image
		BufferedImage img = null;
				
		// Read the input file
		try {
			img = ImageIO.read(inputFile);
		} catch(IOException e) {
			inputError();
		}
		
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
		
		// Write the modified image to the output file
		ImageIO.write(img, "jpg", outputFile);
	}
	
	static void inputError() {
		// Handles any input errors
		System.out.println("Invalid arguments\nUsage: negative [inputfile.jpg] [outputfile.jpg]");
		System.exit(1);
	}
}
