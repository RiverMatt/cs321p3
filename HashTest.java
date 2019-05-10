import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class HashTest {
	
	public static void main(String[] args) {

		/* Setting up the corned beef */
		final int m = 95791;
		double loadfactor;
		int inputType, linearLimit, doubleLimit;
		String source = "";

		if (args.length == 2) {
			inputType = Integer.parseInt(args[0]);
			loadfactor = Double.parseDouble(args[1]);
			if (inputType == 1) {
				source = "Random";
			} else if (inputType == 2) {
				source = "Current time";
			} else if (inputType == 3) {
				source = "word-list";
			} else {
				System.out.printf("Illegal input type.");
				System.exit(-1);
			}
		} else if (args.length == 3) {
			System.out.printf("Debug function not implemented.");
			System.exit(-1);
		} else {
			System.out.printf("Argument error.");
			System.exit(-1);
		}
		
		/* Hashing it out */
	
	}

	/* Other Methods */
}
