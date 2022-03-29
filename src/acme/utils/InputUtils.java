package acme.utils;
import java.math.BigDecimal;
import java.util.Map;

import acme.constant.DayConstant;
import acme.constant.ScheduleConstant;

public class InputUtils {

	/**
	 * Singleton instance.
	 */
	protected static InputUtils instance = null;
	
	private InputUtils() { }
	
	static public InputUtils getInputUtils() {
		 
        if (instance == null) {
        	instance = new InputUtils();
        }
        return instance;
    }

	/**
	 * Utility method for input validation.
	 *
	 * @param input the input to check
	 */
	public Boolean validateInput(String input) {
		boolean valid = true;
		if ((input != null) && (input.split("=").length == 2)) {
			String[] inputArray = input.split("=");
			for(String registry : inputArray[1].split(",")) {
				if(DayConstant.valueOf(registry.substring(0, 2))==null) {
					valid = false;
					System.out.println("Day: " + registry.substring(0, 2)
							+ " not valid");
				}
				if(!TimeUtils.getTimeUtils().validateTimeFormat(registry.substring(2, registry.length()))) {
					valid = false;
				}
			}
			return valid;
		} else {
			System.out.println("Input: " + input
					+ " with incorrect format, please use the format of the following example: RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
			return false;
		}
	}	
	
	/**
	 * Utility method get total.
	 *
	 * @param input the input to calculate
	 */
	public Double getTotal(String input) {
		Double total = (double) 0;
		String[] inputArray = input.split("=");
		for(String registry : inputArray[1].split(",")) {
			Map<ScheduleConstant, Integer> quantities = TimeUtils.getTimeUtils().getQuantityHours(registry.substring(2, registry.length()));
			for (Map.Entry<ScheduleConstant, Integer> entry : quantities.entrySet()) {
				total += (CostUtils.getCostUtils().getCoastPerDay(DayConstant.valueOf(registry.substring(0, 2)), entry.getKey()).multiply(new BigDecimal(entry.getValue()))).doubleValue();
			}
		}
		System.out.println("The amount to pay " + inputArray[0] + " is: " + total.toString() + " USD");
		return total;
	}	
	
}
