/**
* Map from integer to Strings: one to many
*/
public interface SimpleMap2 {
	/**
	* Puts a new String in the map.
	*/
	String put(int key, String name);
	/**
	* Returns all the names associated with that key,
	* or null if there is none.
	*/
	String[] get(int key);
	/**
	* Removes a name from the map.
	*/
	void remove(int key, String name);
	/**
	* Returns true if there are no workers in the map,
	* false otherwise
	*/
	boolean isEmpty();
}