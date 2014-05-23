package geeks.in.action.algo.numtoword;

public enum Scale implements ScaleUnitInterface {
	SHORT, LONG;

	public String getName(int exponent) {
		for (ScaleUnit unit : SCALE_UNITS) {
			if (unit.getExponent() == exponent) {
				return unit.getName(this.ordinal());
			}
		}
		return "";
	}
}
