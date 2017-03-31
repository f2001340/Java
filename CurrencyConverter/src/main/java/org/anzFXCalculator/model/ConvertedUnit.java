package org.anzFXCalculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.anzFXCalculator.domainData.CurrencyDecimalPlacesMap;

/**
 * Domain Object representing the Output of FXCalculator program
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class ConvertedUnit {
	public String sourceCCY;
	public BigDecimal sourceCCYAmt;
	public String destCCY;
	public BigDecimal destCCYAmt;
	private CurrencyDecimalPlacesMap decimalMap = new CurrencyDecimalPlacesMap();

	public ConvertedUnit(String sourceCCY, BigDecimal sourceCCYAmt, String destCCY, BigDecimal destCCYAmt) {
		this.sourceCCY = sourceCCY;
		this.sourceCCYAmt = sourceCCYAmt;
		this.destCCY = destCCY;
		this.destCCYAmt = destCCYAmt;
	}

	@Override
	public String toString() {
		Map<String, Integer> ccyDecimalPlacesMap = decimalMap.getCcyDecimalPlacesMap();
		return "OUTPUT IS --> " +
				sourceCCY + " "
				+ sourceCCYAmt.setScale(ccyDecimalPlacesMap.get(sourceCCY), RoundingMode.CEILING)
				+ " = " + destCCY + " "
				+ destCCYAmt.setScale(ccyDecimalPlacesMap.get(destCCY), RoundingMode.CEILING);
	}

	public BigDecimal getDestCCYAmt() {
		return destCCYAmt;
	}

}
