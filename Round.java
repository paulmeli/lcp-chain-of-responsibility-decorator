package LCPChainOfResponsibilityDecorator;


/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class Round extends ConversionDecorator {

	LengthConversionHandler lengthConversionHandler;

	public Round(LengthConversionHandler lengthConversionHandler){
		this.lengthConversionHandler = lengthConversionHandler;
	}

	public String handleConversion(double length, String conversionUnit){
		return handleRound(lengthConversionHandler.handleConversion(length, conversionUnit));
	}

	public String handleRound(String result){
		double resultDouble = Double.parseDouble(result); // Change result to decimal
		double resultDoubleRound = (double) Math.round(resultDouble * 100) / 100; // Round result 2 decimal places
		return String.valueOf(resultDoubleRound);
	}
}//end Round