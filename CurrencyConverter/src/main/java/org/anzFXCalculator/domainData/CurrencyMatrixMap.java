package org.anzFXCalculator.domainData;

import java.util.HashMap;
import java.util.Map;

import org.anzFXCalculator.model.CurrencyMatrix;

/**
 * My implementation of Cross Currency Matrix Table
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CurrencyMatrixMap {
	Map<String, CurrencyMatrix> ccyMatrixMap = new HashMap<String, CurrencyMatrix>();

	public Map<String, CurrencyMatrix> getCcyMatrixMap() {
		return ccyMatrixMap;
	}

	public CurrencyMatrixMap() {
		ccyMatrixMap.put("AUD",new CurrencyMatrix("AUD","1:1","USD","USD","USD","USD",
				"USD","USD","USD","USD","USD","D"));
		ccyMatrixMap.put("CAD",new CurrencyMatrix("CAD","USD","1:1","USD","USD","USD",
				"USD","USD","USD","USD","USD","D"));
		ccyMatrixMap.put("CNY",new CurrencyMatrix("CNY","USD","USD","1:1","USD","USD",
				"USD","USD","USD","USD","USD","D"));
		ccyMatrixMap.put("CZK",new CurrencyMatrix("CZK","USD","USD","USD","1:1","EUR",
				"Inv","USD","USD","EUR","USD","EUR"));
		ccyMatrixMap.put("DKK",new CurrencyMatrix("DKK","USD","USD","USD","EUR","1:1",
				"Inv","USD","USD","EUR","USD","EUR"));
		ccyMatrixMap.put("EUR",new CurrencyMatrix("EUR","USD","USD","USD","D","D",
				"1:1","USD","USD","D","USD","D"));
		ccyMatrixMap.put("GBP",new CurrencyMatrix("GBP","USD","USD","USD","USD","USD",
				"USD","1:1","USD","USD","USD","D"));
		ccyMatrixMap.put("JPY",new CurrencyMatrix("JPY","USD","USD","USD","USD","USD",
				"USD","USD","1:1","USD","USD","Inv"));
		ccyMatrixMap.put("NOK",new CurrencyMatrix("NOK","USD","USD","USD","EUR","EUR",
				"Inv","USD","USD","1:1","USD","EUR"));
		ccyMatrixMap.put("NZD",new CurrencyMatrix("NZD","USD","USD","USD","USD","USD",
				"USD","USD","USD","USD","1:1","D"));
		ccyMatrixMap.put("USD",new CurrencyMatrix("USD","Inv","Inv","Inv","EUR","EUR",
				"Inv","Inv","D","EUR","Inv","1:1"));
	}
}
