package geeks.in.action.algo.numtoword;

public class CompositeBigNumBuilder extends AbstractNumericBuilder {

	private final HundredNumBuilder hundredProcessor = new HundredNumBuilder();
	private AbstractNumericBuilder lowProcessor;
	private final int exponent;

	public CompositeBigNumBuilder(int exponent) {
		if (exponent <= 3) {
			lowProcessor = hundredProcessor;
		} else {
			lowProcessor = new CompositeBigNumBuilder(exponent - 3);
		}
		this.exponent = exponent;
	}

	public String getToken() {
		return SCALE.getName(getPartDivider());
	}

	protected AbstractNumericBuilder getHighProcessor() {
		return hundredProcessor;
	}

	protected AbstractNumericBuilder getLowProcessor() {
		return lowProcessor;
	}

	public int getPartDivider() {
		return exponent;
	}

	@Override
	public String getName(String value) {
		StringBuilder buffer = new StringBuilder();

		String high, low;
		if (value.length() < getPartDivider()) {
			high = "";
			low = value;
		} else {
			int index = value.length() - getPartDivider();
			high = value.substring(0, index);
			low = value.substring(index);
		}

		String highName = getHighProcessor().getName(high);
		String lowName = getLowProcessor().getName(low);

		if (!highName.isEmpty()) {
			buffer.append(highName);
			buffer.append(SEPARATOR);
			buffer.append(getToken());

			if (!lowName.isEmpty()) {
				buffer.append(SEPARATOR);
			}
		}

		if (!lowName.isEmpty()) {
			buffer.append(lowName);
		}

		return buffer.toString();
	}

}
