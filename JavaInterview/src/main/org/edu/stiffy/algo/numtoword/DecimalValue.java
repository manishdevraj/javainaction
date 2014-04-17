package org.edu.stiffy.algo.numtoword;

import java.math.BigDecimal;

/**
 * Interface that allows us to create Decimal value
 * 
 * @author manishdevraj
 * 
 */
public interface DecimalValue {
	public <T> DecimalValue getInstance(T val);

	public int intValue();

	public long longValue();

	public DecimalValue divide(DecimalValue ten);

	public DecimalValue remainder(DecimalValue ten);

	public BigDecimal getValue();
}
