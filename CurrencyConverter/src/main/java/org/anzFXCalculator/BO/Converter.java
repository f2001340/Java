package org.anzFXCalculator.BO;

import org.anzFXCalculator.model.ConvertedUnit;
import org.anzFXCalculator.model.CurrencyUnit;

public interface Converter {
	public ConvertedUnit convert(CurrencyUnit ccyUnit);
}
