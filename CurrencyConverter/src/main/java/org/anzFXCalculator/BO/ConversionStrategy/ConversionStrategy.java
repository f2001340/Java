package org.anzFXCalculator.BO.ConversionStrategy;

import java.math.BigDecimal;

import org.anzFXCalculator.model.CurrencyUnit;

public interface ConversionStrategy {
	
	public BigDecimal calculate(CurrencyUnit ccyUnit);

}
