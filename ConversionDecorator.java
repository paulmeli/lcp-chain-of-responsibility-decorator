package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public abstract class ConversionDecorator extends LengthConversionHandler {

	public abstract String handleConversion(double length, String conversionUnit);
}//end ConversionDecorator