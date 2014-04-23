package geeks.in.action.algo.numtoword;

/**
 * Enum class based on SCAE up to N HUNDRED, THOUSAND, LAKH, CRORE, etc
 * 
 * @author manishdevraj
 * 
 */
public enum NumberScale {
	HUNDREDS(100, "HUNDRED"),

	THOUSAND(1000, "THOUSAND"),

	THOUSAND2(1000000, "MILLION");

	// TODO Logic is incomplete
	private int index;
	private String numbericWord;

	private NumberScale(final int index, String numbericWord) {
		this.index = index;
		this.numbericWord = numbericWord;
	}

	public int getIndex() {
		return index;
	}

	public String getNumericWord() {
		return numbericWord;
	}

	public static String findWord(final int number) {
		String word = "";
		for (NumberScale numMileStones : values()) {
			if (number == numMileStones.getIndex()) {
				word = numMileStones.getNumericWord();
				break;
			}
		}
		return word;
	}
}
