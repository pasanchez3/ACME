package acme;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateCostTest {

	
	@Test
	public void notValidHour() {
		String input= "RENE=MO10:61-12:00,TU25:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		assertEquals(new Double (0), CalculateCost.calculateCost(input));
	}
	
	@Test
	public void notValidDay() {
		String input= "RENE=MU10:00-12:00,TE10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		assertEquals(new Double (0), CalculateCost.calculateCost(input));
	}
	
	@Test
	public void notEmployeeName() {
		String input= "MU10:00-12:00,TE10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		assertEquals(new Double (0), CalculateCost.calculateCost(input));
	}
	
	@Test
	public void testRene() {
		String input= "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		assertEquals(new Double (215), CalculateCost.calculateCost(input));
	}
	
	@Test
	public void testAstrid() {
		String input= "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
		assertEquals(new Double (85), CalculateCost.calculateCost(input));
	}
	
	@Test
	public void testAlejandro() {
		String input= "ALEJANDRO=MO10:00-10:50,TU07:00-10:00,TU12:00-20:15,SU00:00-23:59";
		// 1 Hour on Monday from (50 minutes is 1 paid hour, the calculation is made by round Half up)
		// 1 * 15 = 15
		// 11 Hour at Tuesday with time off from 10:00 to 12:00
		// 2 * 25 + 7 * 15 + 2 * 20 = 195
		// 24 Hours at Sunday (finishing the task at deadline)
		// 9 * 30 + 9 * 20 + 6 * 25 = 600
		// 810
		assertEquals(new Double (810), CalculateCost.calculateCost(input));
	}

}
