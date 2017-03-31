package org.anzFXCalculator.BO.ConversionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.anzFXCalculator.BO.Converter;
import org.anzFXCalculator.BO.MyConverterImpl;
import org.anzFXCalculator.domainData.CurrencyMatrixMap;
import org.anzFXCalculator.main.CurrencyConverter;
import org.anzFXCalculator.model.ConvertedUnit;
import org.anzFXCalculator.model.CurrencyMatrix;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

/**
 * Cross Currency Conversion Class Implementation of our Conversion Strategy
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CrossConversionStrategy implements ConversionStrategy {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);
	CurrencyMatrixMap matrix = new CurrencyMatrixMap();
	Map<String, CurrencyMatrix> ccyMatrixMap = matrix.getCcyMatrixMap();
	
	/**
	 * Determine Currency Conversion Strategy for Source and Destination Currency
	 * 
	 * @author ADITYA MAJETY
	 * @param sourceCCY Source currency from Currency Matrix
	 * @param destCCY Destination currency in the Currency Matrix
	 * @return Strategy as defined in the Currency Matrix
	 * 
	 */
	public String matrixStrategyLookup(String sourceCCY, String destCCY){
		CurrencyMatrix currencyMatrix = ccyMatrixMap.get(sourceCCY);
		String ccyStrategy = currencyMatrix.getCCY(destCCY);
		logger.debug("Currency Strategy for: " + sourceCCY + "-" + destCCY + " is " + ccyStrategy);
		
		return ccyStrategy;
	}
	
	/**
	 * Fetches the Currency Conversion Rate
	 * 
	 * @author ADITYA MAJETY
	 * @param sourceCCY Source currency from Currency Matrix
	 * @param destCCY Destination currency in the Currency Matrix
	 * @param amountToBeConverted Always 1
	 * @param ccyStrategy Strategy to be used for Conversion
	 * @return Conversion Amount between the two currencies
	 * 
	 */
	public BigDecimal getConversionAmt(String sourceCCY, String destCCY, BigDecimal amountToBeConverted, String ccyStrategy) {
		CurrencyUnit ccyUnit = new CurrencyUnit(sourceCCY,destCCY,amountToBeConverted,ccyStrategy);
		//This could be any of "D" or "1:1" or "Inv" or "CCY"
		Converter myConverter = new MyConverterImpl();
		ConvertedUnit unit = myConverter.convert(ccyUnit);
		BigDecimal conversionAmt = unit.getDestCCYAmt();
		logger.debug(ccyUnit.getSourceCCY() + "-" + ccyUnit.getDestCCY() + " in " + ccyUnit.getCCYStrategy() + " is " + conversionAmt);
		
		return conversionAmt;
	}

	/**
	 * Calculate Currency Conversion
	 * 
	 * @author ADITYA MAJETY
	 * @param ccyUnit Currency Unit used for Conversion. Takes a CurrencyUnit type
	 * @return Currency amount after Conversion
	 * 
	 */
	@Override
	public BigDecimal calculate(CurrencyUnit ccyUnit) {
		String sourceCCY = ccyUnit.getSourceCCY();
		String destCCY = ccyUnit.getDestCCY();
		BigDecimal amountToBeConverted = ccyUnit.getAmount();
		
		String ccyToBeCrossedWith = ccyUnit.getCCYStrategy();
		logger.debug("Source:" + sourceCCY + ",Destination:" + destCCY + "-- to be crossed with: " + ccyToBeCrossedWith);
		
		//Lookup sourceCCY--crossCCY
		String ccyStrategy1 = matrixStrategyLookup(sourceCCY, ccyToBeCrossedWith);
		BigDecimal conversionAmt1 = getConversionAmt(sourceCCY,ccyToBeCrossedWith,new BigDecimal("1"),ccyStrategy1);
				
		//lookup crossCCY-destCCY
		String ccyStrategy2 = matrixStrategyLookup(ccyToBeCrossedWith, destCCY);
		BigDecimal conversionAmt2 = getConversionAmt(ccyToBeCrossedWith,destCCY,new BigDecimal("1"),ccyStrategy2);
		
		BigDecimal convertedAmount = conversionAmt1.multiply(conversionAmt2)
				.multiply(amountToBeConverted)
				.setScale(4, RoundingMode.HALF_EVEN);
		return convertedAmount;
	}

}
