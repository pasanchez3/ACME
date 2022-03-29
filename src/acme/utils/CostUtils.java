package acme.utils;
import java.math.BigDecimal;

import acme.constant.DayConstant;
import acme.constant.ScheduleConstant;

public class CostUtils {

	/**
	 * Singleton instance.
	 */
	protected static CostUtils instance = null;
	
	private CostUtils() { }
	
	static public CostUtils getCostUtils() {
		 
        if (instance == null) {
        	instance = new CostUtils();
        }
        return instance;
    }

	public BigDecimal getCoastPerDay(DayConstant day, ScheduleConstant schedule) {
		if(DayConstant.SATURDAY.equals(day) || DayConstant.SUNDAY.equals(day)) {
			if(ScheduleConstant.FIRST_SCHEDULE.equals(schedule)) {
				return new BigDecimal(30);
			}
			else if(ScheduleConstant.SECOND_SCHEDULE.equals(schedule)) {
				return new BigDecimal(20);
			}
			else {
				return new BigDecimal(25);
			}
		} else {
			if(ScheduleConstant.FIRST_SCHEDULE.equals(schedule)) {
				return new BigDecimal(25);
			}
			else if(ScheduleConstant.SECOND_SCHEDULE.equals(schedule)) {
				return new BigDecimal(15);
			}
			else {
				return new BigDecimal(20);
			}
		}
	}	
}
