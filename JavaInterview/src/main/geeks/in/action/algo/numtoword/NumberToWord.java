package geeks.in.action.algo.numtoword;

/**
 * Main class
 * 
 * @author manishdevraj
 * 
 */
public class NumberToWord {
	static AbstractNumericBuilder numBuilder;

	public static void main(String[] args) {
		long[] values = new long[] { 0, 4, 10, 12, 31, 40, 98, 100, 108, 299,
				400, 788, 999, 1000, 1003, 2040, 45213, 100000, 100005, 100010,
				202020, 202022, 999999, 1000000, 1000001, 10000000, 10000007,
				99999999, Long.MAX_VALUE, Long.MIN_VALUE };

		numBuilder = new GenericNumericBuilder();
		for (long val : values) {
			NumericValue numericValue = new NumericValue(val);
			System.out.println(val + " = " + numBuilder.process(numericValue));
		}

	}
}
