package org.anzFXCalculator.BO;

import java.math.BigDecimal;

import org.anzFXCalculator.BO.ConversionStrategy.ConversionStrategy;
import org.anzFXCalculator.main.CurrencyConverter;
import org.anzFXCalculator.model.ConvertedUnit;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

public class MyConverterImpl implements Converter {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);
	ConversionStrategy strategyObj;
	StrategyBuilder strategyObjBuilder = new StrategyBuilder();

	@Override
	public ConvertedUnit convert(CurrencyUnit ccyUnit) {
		String strategy = ccyUnit.getCCYStrategy();
		strategyObj = strategyObjBuilder.build(strategy);
		BigDecimal calculatedAmount = strategyObj.calculate(ccyUnit);
		
		return new ConvertedUnit(ccyUnit.getSourceCCY(),
				ccyUnit.getAmount(),
				ccyUnit.getDestCCY(),
				calculatedAmount);
	}
}