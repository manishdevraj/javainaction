package geeks.in.action.algo.numtoword;

/**
 * Abstract Numeric Builder that can process any number
 * 
 * @author manishdevraj
 * 
 */
public abstract class AbstractNumericBuilder {
	public abstract String process(DecimalValue val);

	protected final String SPACE = " ";
	protected final String AND = "And ";
}
