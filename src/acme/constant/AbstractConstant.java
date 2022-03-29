package acme.constant;

public abstract class AbstractConstant implements TypedConstant {

	/**
	 * Value of this constant
	 */
	protected String value;
	
	/**
	 * Creates a new Constant.
	 * 
	 * @param name the name of the constant.
	 */
	protected AbstractConstant(String constantName) {
		this.value = constantName;
	}
	
	/**
	 * Returns the constant's value.
	 * 
	 * @return the constant's value.
	 */
	@Override
	public final String getValue() {
		return value;
	}
	
	/**
	 * Returns the string representation of the constant
	 * 
	 * @return the string representation of the constant
	 */
	@Override
	public String toString() {
		return value;
	}
	
}
