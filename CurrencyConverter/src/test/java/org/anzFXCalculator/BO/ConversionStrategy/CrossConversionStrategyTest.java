package org.anzFXCalculator.BO.ConversionStrategy;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.anzFXCalculator.model.CurrencyUnit;
import org.junit.Ignore;
import org.junit.Test;

public class CrossConversionStrategyTest {

	@Test
	public void testCalculateAUD2JPY1() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD","JPY",new BigDecimal("1"),"USD");
		ConversionStrategy dfStrategy = new CrossConversionStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("100.4101");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateAUD2JPY10() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD","JPY",new BigDecimal("10"),"USD");
		ConversionStrategy dfStrategy = new CrossConversionStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("1004.1014");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateNOK2USD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("NOK","USD",new BigDecimal("1"),"EUR");
		ConversionStrategy dfStrategy = new CrossConversionStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("0.1421");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateAUD2DKK1() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD","DKK",new BigDecimal("1"),"USD");
		ConversionStrategy dfStrategy = new CrossConversionStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("5.0575");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}
	
	@Test
	public void testCalculateAUD2DKK100() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD","DKK",new BigDecimal("100"),"USD");
		ConversionStrategy dfStrategy = new CrossConversionStrategy();
		BigDecimal actualConvertedAmt = dfStrategy.calculate(ccyUnit);
		BigDecimal expectedConvertedAmt = new BigDecimal("505.7507");
		assertEquals(expectedConvertedAmt, actualConvertedAmt);
	}

}
