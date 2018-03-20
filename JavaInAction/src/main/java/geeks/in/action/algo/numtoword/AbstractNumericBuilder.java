package geeks.in.action.algo.numtoword;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNumericBuilder {

	protected static final String SEPARATOR = " ";
	protected static final int NO_VALUE = -1;

	/**
	 * Change this scale to support American and modern British value (short
	 * scale) or Traditional British value (long scale)
	 */
	protected Scale SCALE = Scale.SHORT;

	protected List<Integer> getDigits(long value) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		if (value == 0) {
			digits.add(0);
		} else {
			while (value > 0) {
				digits.add(0, (int) value % 10);
				value /= 10;
			}
		}
		return digits;
	}

	public String getName(long value) {
		return getName(Long.toString(value));
	}

	public String getName(double value) {
		return getName(Double.toString(value));
	}

	abstract public String getName(String value);
}
