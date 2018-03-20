package geeks.in.action.java.strings;

/**
 * Find if a integer array has any duplicate numbers
 * 
 * @author manishdevraj
 * 
 */
public class ArrayDuplicate {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean findDuplicate(final int[] array) {
		for (int val : array) {
			int index = Math.abs(val) - 1;
			if (array[index] < 0)
				return true;
			array[index] *= -1;
		}
		return false;
	}

}
