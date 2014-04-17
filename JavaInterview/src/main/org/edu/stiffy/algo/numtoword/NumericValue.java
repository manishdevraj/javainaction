package org.edu.stiffy.algo.numtoword;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Concrete implementation of Decimal value
 * 
 * @author manishdevraj
 * 
 */
public class NumericValue implements DecimalValue {

	// TODO Logic is incomplete

	public static final int HUNDRED = 100;
	public static final int THOUSAND = 1000;
	public static final int LAKHS = 100000;
	public static final int CRORE = 10000000;
	public static final int SCALE = 10;
	public static final DecimalValue TEN = new NumericValue(10);

	private BigDecimal value;
	private BigDecimal[] values;

	public NumericValue(long val) {
		this.value = new BigDecimal(val);
	}

	public NumericValue(String val) {
		this.value = new BigDecimal(val);
	}

	public NumericValue(BigDecimal val) {
		this.value = val;

	}

	@Override
	public <T> DecimalValue getInstance(T val) {
		return new NumericValue(((Number) val).longValue());
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal[] getValues() {
		return values;
	}

	public void setValues(BigDecimal[] values) {
		this.values = values;
	}

	@Override
	public DecimalValue divide(DecimalValue val) {
		System.out.println("" + this.value.divide(val.getValue()));
		return new NumericValue(this.value.divide(val.getValue()));
	}

	@Override
	public DecimalValue remainder(DecimalValue val) {
		System.out.println("" + this.value.remainder(val.getValue()));
		return new NumericValue(this.value.remainder(val.getValue()));
	}

	public DecimalValue[] divideAndRemainder(DecimalValue val) {
		System.out.println("this.value " + this.value.toString());
		BigDecimal[] bigDecArray = this.value
				.divideAndRemainder((BigDecimal) val);
		return (DecimalValue[]) Arrays.copyOf(bigDecArray, bigDecArray.length);
	}

	@Override
	public long longValue() {
		return this.value.longValue();
	}

	@Override
	public int intValue() {
		return this.value.intValue();
	}

}
