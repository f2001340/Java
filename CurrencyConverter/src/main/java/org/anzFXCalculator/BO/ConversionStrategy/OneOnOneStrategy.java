package org.anzFXCalculator.BO.ConversionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.anzFXCalculator.main.CurrencyConverter;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

/**
 * One-One Implementation of our Conversion Strategy
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class OneOnOneStrategy implements ConversionStrategy {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);

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
		return ccyUnit.getAmount().setScale(4, RoundingMode.HALF_EVEN);
	}

}
