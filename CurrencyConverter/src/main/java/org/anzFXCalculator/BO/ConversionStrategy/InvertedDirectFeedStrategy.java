package org.anzFXCalculator.BO.ConversionStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.anzFXCalculator.domainData.DirectFeed;
import org.anzFXCalculator.main.CurrencyConverter;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

/**
 * Inverted Direct Feed Class Implementation of our Conversion Strategy
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class InvertedDirectFeedStrategy implements ConversionStrategy {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);
	DirectFeed directFeed = new DirectFeed();

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
		Map<String, BigDecimal> entry = directFeed.getDirectFeed();
		BigDecimal convertedAmount;

		String sourceCCY = ccyUnit.getSourceCCY();
		String destCCY = ccyUnit.getDestCCY();
		BigDecimal conversionRate = entry.get(destCCY + sourceCCY);
		if(conversionRate == null) {
			convertedAmount = new BigDecimal("0.00");
		} else {
			BigDecimal one = new BigDecimal("1");
			conversionRate = (one).divide(conversionRate, 4, RoundingMode.HALF_EVEN);
			BigDecimal sourceCCYAmount = ccyUnit.getAmount();
			convertedAmount = sourceCCYAmount.multiply(conversionRate)
					.setScale(4, RoundingMode.HALF_EVEN);
		}
		
		return convertedAmount;
	}

}
