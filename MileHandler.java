package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class MileHandler extends LengthConversionHandler {

	public String handleConversion(double length, String conversionUnit) {
		if (conversionUnit.equals("Mile")) {
			double miles = length * 0.621371; // Convert km to miles
			return String.valueOf(miles);
		}
		else if (successor != null) { // If successor exists, let successor handle
			return successor.handleConversion(length, conversionUnit);
		}
		else {
			return "";
		}
	}
}//end MileHandler