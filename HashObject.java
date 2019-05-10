import java.io.*;

public class HashObject<T> {

	/* Instance Variables */
	private T obj;
	private int dupCount, probeCount;
	private long key;

	/* Constructor */
	public HashObject(T _obj) {
		key = _obj.hashCode();
		obj = _obj;
		dupCount = 0;
		probeCount = 0;
	}

	/* Other Methods */

	public long getKey() {
		return key;
	}

	public T getObj() {
		return obj;
	}
	
	public int getDupCount() {
		return dupCount;
	}

	public int getProbeCount() {
		return probeCount;
	}

	public void incDupCount() {
		dupCount++;
	}

	public void incProbeCount() {
		probeCount++;
	}

	public boolean equals(HashObject<T> _obj) {
		return (_obj != null && obj.equals(_obj.getObj()));
	}

	public String toString() {
		return obj.toString();
	}
}
