
public class HashObject<T> {

	/* Instance Variables */
	private T obj;
	private long key;

	/* Constructor */
	public HashObject(T _obj) {
		key = _obj.hashCode();
		obj = _obj;
	}

	/* Other Methods */

	public long getKey() {
		return key;
	}

	public T getObj() {
		return obj;
	}

	public boolean equals(HashObject<T> _obj) {
		return (_obj != null && obj.equals(_obj.getObj()));
	}

	public String toString() {
		return obj.toString();
	}
}
