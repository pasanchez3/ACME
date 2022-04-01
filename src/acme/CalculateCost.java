package acme;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import acme.utils.InputUtils;

public class CalculateCost {

	public static void main(String[] args) {
		readFileAndCalculateCost();
	}
	public static Double calculateCost(String input) {
		if(!InputUtils.getInputUtils().validateInput(input)) {
			System.out.println("The input is not valid: " + input);
			return (double) 0;
		} else {
			return InputUtils.getInputUtils().getTotal(input);
		}
	}
	public static void readFileAndCalculateCost() {
		File file = new File("src/acme/inputFile.txt");
		try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                	if(!InputUtils.getInputUtils().validateInput(line)) {
            			System.out.println("The input is not valid: " + line);
            		} else {
            			InputUtils.getInputUtils().getTotal(line);
            		}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
