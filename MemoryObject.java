package memoryMgmtSystem;

public class MemoryObject {

	private String name;
	private String function;
	private int size;
	
	public MemoryObject (String word, String fun, int num) {
		name = word;
		function = fun;
		size = num;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String word) {
		name = word;
	}
	
	public String getFunction () {
		return function;
	}
	
	public void setFunction (String fun) {
		function = fun;
	}
	
	public int getSize () {
		return size;
	}
	
	public void setSize (int num) {
		size = num;
	}
	
}
