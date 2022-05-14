package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class ExponentialNotation extends ConversionDecorator {

	LengthConversionHandler lengthConversionHandler;

	public ExponentialNotation(LengthConversionHandler lengthConversionHandler){
		this.lengthConversionHandler = lengthConversionHandler;
	}

	public String handleConversion(double length, String conversionUnit){
		return handleExponentialNotation(lengthConversionHandler.handleConversion(length, conversionUnit));
	}

	public String handleExponentialNotation(String result){
		double resultDouble = Double.parseDouble(result); // Change result to decimal
		return String.format("%e", resultDouble); // Return formatted string in exponential notation
	}
}//end ExponentialNotation