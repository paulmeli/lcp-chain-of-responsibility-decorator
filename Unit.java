package LCPChainOfResponsibilityDecorator;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class Unit extends ConversionDecorator {

	LengthConversionHandler lengthConversionHandler;

	public Unit(LengthConversionHandler lengthConversionHandler){
		this.lengthConversionHandler = lengthConversionHandler;
	}

	public String handleConversion(double length, String conversionUnit){
		String conversionUnitPlural = "";

		// Get correct unit plural
		if (conversionUnit.equals("Mile")) { conversionUnitPlural = "Miles"; } 
		else if (conversionUnit.equals("Yard")) { conversionUnitPlural = "Yards"; } 
		else if (conversionUnit.equals("Foot")) { conversionUnitPlural = "Feet"; }
		
		return lengthConversionHandler.handleConversion(length, conversionUnit) + " " + conversionUnitPlural;
	}
}//end Unit