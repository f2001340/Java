package org.anzFXCalculator.BO.ConversionStrategy;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.anzFXCalculator.BO.ConversionStrategy.ConversionStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.DirectFeedStrategy;
import org.anzFXCalculator.model.CurrencyUnit;
import org.junit.Test;

public class DirectFeedStrategyTest {

	@Test
	public void testCalculateAUD2USD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD","USD",new BigDecimal("1"),"");
		ConversionStrategy dfStrategy = new DirectFeedStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("0.8371");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateCAD2USD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("CAD","USD",new BigDecimal("1"),"");
		ConversionStrategy dfStrategy = new DirectFeedStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("0.8711");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateUSD2JPY() {
		CurrencyUnit ccyUnit = new CurrencyUnit("USD","JPY",new BigDecimal("1"),"");
		ConversionStrategy dfStrategy = new DirectFeedStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("119.9500");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateEUR2NOK() {
		CurrencyUnit ccyUnit = new CurrencyUnit("EUR","NOK",new BigDecimal("1"),"");
		ConversionStrategy dfStrategy = new DirectFeedStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("8.6651");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateUSD2AUD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("USD","AUD",new BigDecimal("1"),"");
		ConversionStrategy dfStrategy = new DirectFeedStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("0.00");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}

}
