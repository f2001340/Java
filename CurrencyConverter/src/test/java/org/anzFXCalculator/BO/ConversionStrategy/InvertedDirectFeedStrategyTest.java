package org.anzFXCalculator.BO.ConversionStrategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.anzFXCalculator.BO.ConversionStrategy.ConversionStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.InvertedDirectFeedStrategy;
import org.anzFXCalculator.model.CurrencyUnit;
import org.junit.Test;

public class InvertedDirectFeedStrategyTest {

	@Test
	public void testCalculateUSDAUD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("USD","AUD",new BigDecimal("1"), "");
		ConversionStrategy invDfStrategy = new InvertedDirectFeedStrategy();
		BigDecimal actualConvertedAmt = invDfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("1.1946");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}

}
