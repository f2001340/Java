package org.anzFXCalculator.BO;

import org.anzFXCalculator.BO.ConversionStrategy.ConversionStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.CrossConversionStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.DirectFeedStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.InvertedDirectFeedStrategy;
import org.anzFXCalculator.BO.ConversionStrategy.OneOnOneStrategy;
import org.anzFXCalculator.main.CurrencyConverter;
import org.apache.log4j.Logger;

/**
 * Return the object implementation of specified Strategy
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class StrategyBuilder {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);

	public ConversionStrategy build(String strategy) {
		ConversionStrategy strategyObj;

		switch (strategy) {
		case "D":
			strategyObj = new DirectFeedStrategy();
			logger.debug("Applying Direct Feed Strategy.");
			break;

		case "1:1":
			strategyObj = new OneOnOneStrategy();
			logger.debug("Applying 1:1 Feed Strategy.");
			break;

		case "Inv":
			strategyObj = new InvertedDirectFeedStrategy();
			logger.debug("Applying Inverted Direct Feed Strategy.");
			break;

		default:
			strategyObj = new CrossConversionStrategy();
			logger.debug("Applying Cross Currency Strategy.");
			break;
		}

		return strategyObj;
	}

}
