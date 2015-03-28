package memoryMgmtSystem;

public class Core {

	private static String [] memory;
	private int numItems;
	private static int size;
	
	public static void main (String args []) {
		new Core();
	}
	
	public Core () {
		size = 32;
		memory = new String [size];
		numItems = 0;
	}
	
	public static Object [] startMemory (Object [] array) throws MemoryException {
		memory = new String [32];
		for (int i = 0; i < memory.length; i++) {
			memory[i] = "empty";
		}
		for (int i = 0; i < array.length; i++) {
			MemoryObject current = (MemoryObject) array [i];
			if (current == null) {
				;
			}
			else if (current.getFunction().equals("add")) {
				add(current);
			}
			else if (current.getFunction().equals("remove")) {
				remove(current);
			}
			else {
				throw new MemoryException("Function String Not Allowed.");
			}
		}
		return memory;
	}
	
	public static void add (MemoryObject item) {
		int thisSize = item.getSize();
		int [] position = findPosition(thisSize);
		if (position [0] == position [1]) {
			System.out.println("No available positions for object " + item.getName() + ".");
			return;
		}
		for (int i = position [0]; i < position [1]; i++) {
			memory [i] = item.getName();
		}
	}
	
	public static void remove (MemoryObject item) {
		int thisSize = item.getSize();
		String name = item.getName();
		int subSize = findSubSize(thisSize);
		for (int i = 0; i < memory.length; i += subSize) {
			if (memory [i].equals(name)) {
				for (int j = i; j < i + subSize; j++) {
					memory [j] = "empty";
				}
			}
		}
	}
	
	public static int findSubSize (int value) {
		int subSize = memory.length;
		while (subSize > 1) {
			if (value < subSize && subSize / 2 > value) {
				subSize = subSize / 2;
			}
			else {
				return subSize;
			}
		}
		return 0;
	}
	
	public static int [] findPosition (int value) {
		int [] position = new int [2];
		int subSize = findSubSize(value);
		for (int i = 0; i < memory.length; i += subSize) {
			boolean canFit = true;
			for (int j = i; j < i + subSize; j++) {
				if (!memory[j].equals("empty")) {
					canFit = false;
					break;
				}
			}
			if (canFit == false) {
				;
			}
			else {
				position [0] = i;
				position [1] = i + subSize;
				return position;
			}
		}
		return position;
	}
	
}
