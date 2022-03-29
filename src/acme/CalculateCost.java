package acme;
import acme.utils.InputUtils;

public class CalculateCost {

	public static Double calculateCost(String input) {
		if(!InputUtils.getInputUtils().validateInput(input)) {
			System.out.println("The input is not valid: " + input);
			return (double) 0;
		} else {
			return InputUtils.getInputUtils().getTotal(input);
		}
	}
	
}
