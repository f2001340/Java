package org.anzFXCalculator.BO;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.anzFXCalculator.model.ConvertedUnit;
import org.anzFXCalculator.model.CurrencyUnit;
import org.junit.Test;

public class MyConverterImplTest {
	Converter myConverter = new MyConverterImpl();

	@Test
	public void testConvertAUD2USD() {
		CurrencyUnit ccyUnit = new CurrencyUnit("AUD", "USD", new BigDecimal("100.00"),"D");
		ConvertedUnit convertedCCY = myConverter.convert(ccyUnit);
		assertEquals("OUTPUT IS --> AUD 100.00 = USD 83.71", convertedCCY.toString());
	}
	
}
