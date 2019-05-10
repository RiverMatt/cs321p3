import java.io.*;

public class HashTable<E> {
	
	/* Instance Variables */
	private final int m = 95791;	// twin is 95789
	private int n, probeType, insertCount, probeTotal, dupTotal, load;
	private double loadFactor;
	private HashObject<E>[] A;
	private int[] probeCount;

	/* Constructor */
	@SuppressWarnings("unchecked")
	public HashTable(int _probeType, double _loadFactor) {
		
		probeType = _probeType;
		loadFactor = _loadFactor;
		
		n = (int) loadFactor*m;	// load
		
		A = (HashObject<E>[]) new HashObject[m];
		insertCount = 0;
		probeTotal = 0;
		dupTotal = 0;

		probeCount = new int[m];


	}
	
	/* Other Methods */

	private int hashfct(long _key, int i) {
	
		int hashindex;
		
		if (probeType == 1) {
			hashindex = (int) ((_key % m + i) % m);
			return hashindex;
		} else {
			hashindex = (int) ((_key % m) + i*(1 + _key % (m-2))) % m;
			return hashindex;
		}
	
	}

	public int insert(HashObject<E> _hashobj, long _key) {
		
		int hashindex;

		while (insertCount <= n) {
			for (int i = 0; i < m; i++) {
				hashindex = hashfct(_key, i);
				if (hashindex < 0) {
					hashindex += m;
				}
				if (A[hashindex] == null) {
					A[hashindex] = _hashobj;
					probeCount[hashindex]++;
					probeTotal++;
					insertCount++;
					return hashindex;
				} else if (A[hashindex].equals(_hashobj)) {
					A[hashindex].incDupCount();
					dupTotal++;
					probeCount[hashindex]++;
					probeTotal++;
					return hashindex;
				}
				probeCount[hashindex]++;
				probeTotal++;
				
			}
		}

		return -1;
	}

	public HashObject<E>[] getTable() {
		return A;
	}

	public int[] getProbeCount() {
		return probeCount;
	}
	
	public int getProbeTotal() {
		return probeTotal;
	}

	public int getInsertCount() {
		return insertCount;
	}
}
