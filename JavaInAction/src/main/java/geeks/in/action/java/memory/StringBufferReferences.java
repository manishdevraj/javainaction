package geeks.in.action.java.memory;


/**
 * [Buffer Object | Flags | Value ]
 * 
 * [Class reference | Flags | {Char array} O N E T W O ]
 * 
 * @author manishdevraj
 * 
 */
public class StringBufferReferences {
	StringBuffer buffer = new StringBuffer();

	public static void main(String[] args) {
		StringBufferReferences ref = new StringBufferReferences();
		ref.display();
	}

	/**
	 * Display
	 */
	private void display() {
		System.out.println(getWords().toString());
	}

	/**
	 * Get Words
	 * 
	 * @return
	 */
	private StringBuffer getWords() {
		try {
			buffer.append("ONE");
			buffer.append("TWO");
			return buffer;
		} finally {
			// This shall print ONETWOTHREE
			// buffer.append("THREE");
			buffer = null; // This shall print ONETWO
		}
	}

}
