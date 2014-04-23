package geeks.in.action.algo.numtoword;

/**
 * Enum constant that store unique numers and special cases scenarios like 11,
 * 12, ... 19
 * 
 * @author manishdevraj
 * 
 */
public enum UniqueNumbers {
	ZERO(0, "Zero"),

	ONE(1, "One"),

	TWO(2, "Two"),

	THREE(3, "Three"),

	FOUR(4, "Four"),

	FIVE(5, "Five"),

	SIX(6, "Six"),

	SEVEN(7, "Seven"),

	EIGHT(8, "Eight"),

	NINE(9, "Nine"),

	TEN(10, "Ten"),

	ELEVEN(11, "Eleven"),

	TWELVE(12, "Twelve"),

	THIRTEEN(13, "Thirteen"),

	FOURTEEN(14, "Fourteen"),

	FIFTEEN(15, "Fifteen"),

	SIXTEEN(16, "Sixteen"),

	SEVENTEEN(17, "Seventeen"),

	EIGHTEEN(18, "Eighteen"),

	NINETEEN(19, "Nineteen"),

	TWENTY(20, "Twenty"),

	THIRTY(30, "Thirty"),

	FOURTY(40, "Fourty"),

	FIFTY(50, "Fifty"),

	SIXTY(60, "Sixty"),

	SEVENTY(70, "Seventy"),

	EIGHTY(80, "Eighty"),

	NINETY(90, "Ninety");

	/**
	 * Number to be translated
	 */
	private int numValue;

	/**
	 * The string value of this enum
	 */
	private String numbericWord;

	/**
	 * 
	 * Private constructor used internally to instantiate this enum type
	 * 
	 * @param intValue
	 *            The int value of this enum
	 * @param translation
	 *            The String value of this enum
	 * 
	 */
	private UniqueNumbers(final int numValue, final String numbericWord) {
		this.numValue = numValue;
		this.numbericWord = numbericWord;
	}

	public int getNumValue() {
		return this.numValue;
	}

	public String getNumericWord() {
		return numbericWord;
	}

	public static String findWord(final int number) {
		String word = "";
		for (UniqueNumbers uniqueNum : values()) {
			if (number == uniqueNum.getNumValue()) {
				word = uniqueNum.getNumericWord();
				break;
			}
		}
		return word;
	}
}
