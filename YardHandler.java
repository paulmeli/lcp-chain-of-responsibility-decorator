package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class YardHandler extends LengthConversionHandler {

	public String handleConversion(double length, String conversionUnit) {
		if (conversionUnit.equals("Yard")) {
			double yards = length * 1093.61; // Convert km to yards
			return String.valueOf(yards);
		}
		else if (successor != null) { // If successor exists, let successor handle
			return successor.handleConversion(length, conversionUnit);
		}
		else {
			return "";
		}
	}
}//end YardHandler