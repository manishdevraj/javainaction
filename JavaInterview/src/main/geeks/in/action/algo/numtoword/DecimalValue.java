package geeks.in.action.algo.numtoword;

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

	public DecimalValue divide(DecimalValue val);

	public DecimalValue remainder(DecimalValue val);

	public DecimalValue multiply(DecimalValue val);

	public BigDecimal getValue();
}
