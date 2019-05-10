import java.io.*;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class HashTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		/* Setting up the corned beef */
		final int m = 95791;
		double loadfactor = 0.0;
		int inputType = 0; 
		int linearLimit = 0; 
		int doubleLimit = 0;
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
		HashTable lh = new HashTable(1, loadfactor);
		HashTable dh = new HashTable(2, loadfactor);

		if (inputType == 1) {
			Random rand = new Random();
			while (linearLimit != -1) {
				int n = rand.nextInt();
				HashObject<Integer> obj = new HashObject<Integer>(n);
				long key = obj.getKey();
				linearLimit = lh.insert(obj, key);
			}
			while (doubleLimit != -1) {
				int n = rand.nextInt();
				HashObject<Integer> obj = new HashObject<Integer>(n);
				long key = obj.getKey();
				doubleLimit = dh.insert(obj, key);
			}

		} else if (inputType == 2) {
			while (linearLimit != -1) {
				long n = System.currentTimeMillis();
				HashObject<Long> obj = new HashObject<Long>(n);
				long key = obj.getKey();
				linearLimit = lh.insert(obj, key);
			}
			while (doubleLimit != -1) {
				long n = System.currentTimeMillis();
				HashObject<Long> obj = new HashObject<Long>(n);
				long key = obj.getKey();
				doubleLimit = dh.insert(obj, key);
			}
		} else if (inputType == 3) {
			try {
				File f = new File("word-list");
				Scanner scan = new Scanner(f);
				while (linearLimit != -1) {
					while (scan.hasNext()) {
						String n = scan.next();
						HashObject<String> obj = new HashObject<String>(n);
						long key = obj.getKey();
						linearLimit = lh.insert(obj, key);
					}
				}
				scan.close();

				Scanner scan2 = new Scanner(f);
				while (doubleLimit != -1) {
					while (scan2.hasNext()) {
						String n = scan2.next();
						HashObject<String> obj = new HashObject<String>(n);
						long key = obj.getKey();
						doubleLimit = lh.insert(obj, key);
					}
					
				}
				scan2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/* Serving the hash */
		System.out.printf("Table size: %d\n", m);
		System.out.printf("Data source: %s\n", source);
		System.out.printf("Linear hash:\nInserted %5d elements, with %5d duplicates\nLoad factor: %3d, Average number of probes: %4d", lh.getInsertCount(), lh.getDupTotal(), loadfactor, lh.getProbeAverage());
		System.out.printf("\n\n");
		System.out.printf("Double hash:\nInserted %5d elements, with %5d duplicates\nLoad factor: %3d, Average number of probes: %4d", dh.getInsertCount(), dh.getDupTotal(), loadfactor, dh.getProbeAverage());
	}

	/* Other Methods */

//	private static String output() {
//		System.out.printf("Table size: %d", m);
//	}
}
