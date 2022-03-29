package acme.utils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import acme.constant.ScheduleConstant;

public class TimeUtils {

	/**
	 * Singleton instance.
	 */
	protected static TimeUtils instance = null;
	
	private TimeUtils() { }
	
	static public TimeUtils getTimeUtils() {
		 
        if (instance == null) {
        	instance = new TimeUtils();
        }
        return instance;
    }

	/**
	 * Utility method for hours format validation.
	 *
	 * @param hours the hours to check
	 */
	public Boolean validateTimeFormat(String hourLabel) {
		if ((hourLabel != null) && (hourLabel.trim().length() == 11)) {
			String[] hoursArray = hourLabel.split("-");
			boolean valid = true;
			for (String hour : hoursArray) {
				if(!validateTimeFormat(hour)) {
					valid = false;
				}
			}
			return valid;
		}
		if ((hourLabel != null) && (hourLabel.trim().length() == 5)) {
			try {
				LocalTime.parse(hourLabel);
				return true;
			} catch (DateTimeParseException | NullPointerException e) {
				System.out.println("The following value is not a valid hour: " + hourLabel);
				return false;
			}
		} else {
			System.out.println("Hours: " + hourLabel
					+ " with incorrect format, please use the following format: HH:mm-HH:mm");
			return false;
		}
	}
	
	/**
	 * Utility method to get the quantity hours by schedule.
	 *
	 * @param hours the hours to check
	 */
	public Map<ScheduleConstant, Integer> getQuantityHours(String hours) {
		Map<ScheduleConstant, Integer> result = new HashMap<>();
		for (ScheduleConstant schedule : ScheduleConstant.values()) {
			String[] scheduleArray = schedule.getValue().split("-");
			LocalTime scheduleFrom = LocalTime.parse(scheduleArray[0]);
			LocalTime scheduleTo = LocalTime.parse(scheduleArray[1]);
			String[] hoursArray = hours.split("-");
			LocalTime hoursFrom = LocalTime.parse(hoursArray[0]);
			LocalTime hoursTo = LocalTime.parse(hoursArray[1]);
			if ((hoursFrom.isAfter(scheduleFrom) || hoursFrom.equals(scheduleFrom))
					&& (hoursFrom.isBefore(scheduleTo) || hoursFrom.equals(scheduleTo))) {
				if (hoursTo.isAfter(scheduleTo)) {
					result.put(schedule, new BigDecimal(ChronoUnit.MINUTES.between(hoursFrom, scheduleTo))
							.divide(new BigDecimal(60), RoundingMode.HALF_UP).intValue());
				} else {
					result.put(schedule, new BigDecimal(ChronoUnit.MINUTES.between(hoursFrom, hoursTo))
							.divide(new BigDecimal(60), RoundingMode.HALF_UP).intValue());
				}
			} else if ((hoursTo.isAfter(scheduleFrom) || hoursTo.equals(scheduleFrom))
					&& (hoursTo.isBefore(scheduleTo) || hoursTo.equals(scheduleTo))) {
				if (hoursFrom.isAfter(scheduleFrom)) {
					result.put(schedule, new BigDecimal(ChronoUnit.MINUTES.between(hoursFrom, hoursTo))
							.divide(new BigDecimal(60), RoundingMode.HALF_UP).intValue());
				} else {
					result.put(schedule, new BigDecimal(ChronoUnit.MINUTES.between(scheduleFrom, hoursTo))
							.divide(new BigDecimal(60), RoundingMode.HALF_UP).intValue());
				}
			} else if (hoursFrom.isBefore(scheduleFrom) && hoursTo.isAfter(scheduleTo)) {
				result.put(schedule, new BigDecimal(ChronoUnit.MINUTES.between(scheduleFrom, scheduleTo))
						.divide(new BigDecimal(60), RoundingMode.HALF_UP).intValue());
			}
		}
		return result;
	}
	
}
