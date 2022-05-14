package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class FootHandler extends LengthConversionHandler {

	public String handleConversion(double length, String conversionUnit) {
		if (conversionUnit.equals("Foot")) {
			double feet = length * 3280.84; // Convert km to feet
			return String.valueOf(feet);
		}
		else if (successor != null) { // If successor exists, let successor handle
			return successor.handleConversion(length, conversionUnit);
		}
		else {
			return "";
		}
	}
}//end FootHandler