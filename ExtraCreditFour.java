package edu.mtc.egr281.extraCredit;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*/
 *  Rick Howell
 *  Extra Credit 04
 *  12/05/21
 *  This program will take an input text file and create a two column x n row table from the contents
 */

public class ExtraCreditFour {

	public static void main(String[] args) {
		
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Note: please include the file extension when typing the names!");
			System.out.print("Enter the input file (from project folder): ");
			String fileName = input.next();
			FileReader fr = new FileReader(fileName);
			System.out.print("Now what you would like the output folder to be named: ");
			String fileOut = input.next();
			PrintWriter pw = new PrintWriter(fileOut);
			String text = "";
			int i;
			while ((i = fr.read()) != -1) {
				text += (char)i;
			} // while
			//System.out.println(text);
			text = text.trim();
			text = text.replaceAll("\\s{2,}", " ");
			Scanner scanner = new Scanner(text);
			String x = null, y = null;
			i = 0;
			while(scanner.hasNext()) {
				if(i%2 == 0) {
					x = scanner.next();
				} else {
					y = scanner.next();
					pw.println(x + " " + y);
				} // if else
				++ i;
			} // inner while
			input.close();
			scanner.close();
			fr.close();
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("EOP");
			System.exit(0);
		} // try catch block
		
	} // main method
	
} // class