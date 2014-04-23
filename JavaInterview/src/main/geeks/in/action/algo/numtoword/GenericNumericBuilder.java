package geeks.in.action.algo.numtoword;

/**
 * One of the numeric builder that diverts logic to concrete numeric builder
 * based on scale
 * 
 * @author manishdevraj
 * 
 */
public class GenericNumericBuilder extends AbstractNumericBuilder {

	UnitNumericBuilder unitBuilder;
	BigNumericBuilder bigNumericBuilder;

	public GenericNumericBuilder() {
		unitBuilder = new UnitNumericBuilder();
		bigNumericBuilder = new BigNumericBuilder();
	}

	// TODO Logic is incomplete
	@Override
	public String process(DecimalValue val) {
		String response = "";
		int scale = String.valueOf(val.intValue()).length();
		System.out.println("SCALE " + scale);
		if (scale <= 2) {
			response = unitBuilder.process(val);
		} else {
			response = bigNumericBuilder.process(val);
		}
		return response;
	}

}
