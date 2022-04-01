package acme.constant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class defining the schedule constants.
 * 
 * @author asanchez
 */
public class ScheduleConstant extends AbstractConstant {

	/** The Constant FIRST_SCHEDULE. */
	public static final ScheduleConstant FIRST_SCHEDULE = new ScheduleConstant("00:01-09:00");

	/** The Constant SECOND_SCHEDULE. */
	public static final ScheduleConstant SECOND_SCHEDULE = new ScheduleConstant("09:01-18:00");

	/** The Constant THIRD_SCHEDULE. */
	public static final ScheduleConstant THIRD_SCHEDULE = new ScheduleConstant("18:01-23:59");

	/**
	 * Instantiates a new Schedule Constant.
	 *
	 * @param constantValue the constant value
	 */
	protected ScheduleConstant(String constantValue) {
		super(constantValue);
	}

	/**
	 * The Values.
	 *
	 * @return the schedule constants[]
	 */
	public static ScheduleConstant[] values() {
		return values.toArray(new ScheduleConstant[] {});
	}
	
	/** The values. */
	protected static Set<ScheduleConstant> values;
	
	static {
		Set<ScheduleConstant> types = new HashSet<ScheduleConstant>();
		types.addAll(Arrays.asList(new ScheduleConstant[] {FIRST_SCHEDULE, SECOND_SCHEDULE, THIRD_SCHEDULE}));
		values = types;
	}
	
	/**
	 * Value of.
	 *
	 * @param value the value
	 * @return the schedule constant
	 */
	public ScheduleConstant valueOf(String value) {
		for (ScheduleConstant type : values) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
