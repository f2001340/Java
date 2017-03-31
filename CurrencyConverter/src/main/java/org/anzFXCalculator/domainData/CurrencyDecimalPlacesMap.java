package org.anzFXCalculator.domainData;

import java.util.HashMap;
import java.util.Map;

/**
 * My Implementation of Currency Decimal Places Mapping
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CurrencyDecimalPlacesMap {
	Map<String, Integer> ccyDecimalPlacesMap = new HashMap<String, Integer>();

	public Map<String, Integer> getCcyDecimalPlacesMap() {
		return ccyDecimalPlacesMap;
	}

	public CurrencyDecimalPlacesMap() {
		ccyDecimalPlacesMap.put("AUD", 2);
		ccyDecimalPlacesMap.put("CAD", 2);
		ccyDecimalPlacesMap.put("CNY", 2);
		ccyDecimalPlacesMap.put("CZK", 2);
		ccyDecimalPlacesMap.put("DKK", 2);
		ccyDecimalPlacesMap.put("EUR", 2);
		ccyDecimalPlacesMap.put("GBP", 2);
		ccyDecimalPlacesMap.put("JPY", 0);
		ccyDecimalPlacesMap.put("NOK", 2);
		ccyDecimalPlacesMap.put("NZD", 2);
		ccyDecimalPlacesMap.put("USD", 2);
	}

}
