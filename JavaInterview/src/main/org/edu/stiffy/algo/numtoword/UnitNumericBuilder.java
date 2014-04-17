package org.edu.stiffy.algo.numtoword;

/**
 * This would process numbers with unit scale based on
 * {@code org.edu.stiffy.algo.numtoword.UniqueNumbers}
 * 
 * @author manishdevraj
 * 
 */
public class UnitNumericBuilder extends AbstractNumericBuilder {

	// TODO Logic is incomplete

	@Override
	public String process(DecimalValue val) {
		if (String.valueOf(val.intValue()).length() == 1) {
			System.out.println(val.intValue() + "#");
			return UniqueNumbers.findWord(val.intValue());
		} else {
			DecimalValue divident = val.divide(NumericValue.TEN);
			DecimalValue remainder = val.remainder(NumericValue.TEN);
			System.out.println(divident.intValue() + "*" + divident.intValue());
			if (divident.intValue() <= 10) {
				return UniqueNumbers.findWord(divident.intValue()
						* NumericValue.TEN.intValue())
						+ UniqueNumbers.findWord(remainder.intValue());
			}
		}
		return null;
	}
}
