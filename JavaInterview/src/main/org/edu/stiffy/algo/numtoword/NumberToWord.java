package org.edu.stiffy.algo.numtoword;

/**
 * Main class
 * 
 * @author manishdevraj
 * 
 */
public class NumberToWord {
	static AbstractNumericBuilder numBuilder;

	public static void main(String[] args) {
		long[] values = new long[] { 0, 4, 10, 12, 100, 108, 299, 1000, 1003,
				2040 };

		numBuilder = new GenericNumericBuilder();
		for (long val : values) {
			NumericValue numericValue = new NumericValue(val);
			System.out.println(val + " = " + numBuilder.process(numericValue));
		}

	}

}
