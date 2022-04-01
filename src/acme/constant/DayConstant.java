package acme.constant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class defining the day constants.
 * 
 * @author asanchez
 */
public class DayConstant extends AbstractConstant {

	/** The Constant MONDAY. */
	public static final DayConstant MONDAY = new DayConstant("MO");

	/** The Constant TUESDAY. */
	public static final DayConstant TUESDAY = new DayConstant("TU");

	/** The Constant WEDNESDAY. */
	public static final DayConstant WEDNESDAY = new DayConstant("WE");

	/** The Constant THURSDAY. */
	public static final DayConstant THURSDAY = new DayConstant("TH");

	/** The Constant FRIDAY. */
	public static final DayConstant FRIDAY = new DayConstant("FR");

	/** The Constant SATURDAY. */
	public static final DayConstant SATURDAY = new DayConstant("SA");
	
	/** The Constant SUNDAY. */
	public static final DayConstant SUNDAY = new DayConstant("SU");
	
	/**
	 * Instantiates a new day Constant.
	 *
	 * @param constantValue the constant value
	 */
	protected DayConstant(String constantValue) {
		super(constantValue);
	}

	/** The values. */
	protected static Set<DayConstant> values;
	
	static {
		Set<DayConstant> types = new HashSet<DayConstant>();
		types.addAll(Arrays.asList(new DayConstant[] {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}));
		values = types;
	}
	
	/**
	 * Value of.
	 *
	 * @param value the value
	 * @return the day constant
	 */
	public static DayConstant valueOf(String value) {
		for (DayConstant type : values) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
