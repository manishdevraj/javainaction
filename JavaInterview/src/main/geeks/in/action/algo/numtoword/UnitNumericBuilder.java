package geeks.in.action.algo.numtoword;

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
		return getLessThanHundred(val);
	}

	private String getLessThanHundred(DecimalValue val) {
		DecimalValue divident = val.divide(NumericValue.TENS);
		DecimalValue remainder = val.remainder(NumericValue.TENS);
		if (divident.intValue() > UniqueNumbers.ZERO.getNumValue()
				&& remainder.intValue() == UniqueNumbers.ZERO.getNumValue()
				|| divident.intValue() == UniqueNumbers.ONE.getNumValue()) {
			return UniqueNumbers.findWord(val.intValue());
		} else if (divident.intValue() > UniqueNumbers.ONE.getNumValue()) {
			return UniqueNumbers
					.findWord(divident.multiply(NumericValue.TENS).intValue())
					.concat(SPACE)
					.concat(UniqueNumbers.findWord(remainder.intValue()));
		}
		return SPACE;
	}
}