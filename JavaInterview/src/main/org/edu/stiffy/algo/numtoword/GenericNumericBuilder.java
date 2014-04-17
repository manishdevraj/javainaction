package org.edu.stiffy.algo.numtoword;

/**
 * One of the numeric builder that diverts logic to concrete numeric builder
 * based on scale
 * 
 * @author manishdevraj
 * 
 */
public class GenericNumericBuilder extends AbstractNumericBuilder {

	UnitNumericBuilder unitBuilder;

	public GenericNumericBuilder() {
		unitBuilder = new UnitNumericBuilder();
	}

	// TODO Logic is incomplete

	@Override
	public String process(DecimalValue val) {
		String response = "";
		int scale = String.valueOf(val.intValue()).length();
		System.out.println("SCALE " + scale);
		switch (scale) {
		case 1:
			response = unitBuilder.process(val);
			break;
		case 2:
			response = unitBuilder.process(val);
			break;
		default:
			break;
		}

		return response;
	}
}
