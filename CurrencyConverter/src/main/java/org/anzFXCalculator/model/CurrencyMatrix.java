package org.anzFXCalculator.model;

/**
 * Domain Object representing A Row in the Currency Matrix Map
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CurrencyMatrix {
	public String baseCurrency;
	public String AUD, CAD, CNY, CZK, DKK, EUR, GBP, JPY, NOK, NZD, USD;

	public CurrencyMatrix(String baseCurrency, String aUD, String cAD, String cNY, String cZK, String dKK, String eUR,
			String gBP, String jPY, String nOK, String nZD, String uSD) {
		this.baseCurrency = baseCurrency;
		AUD = aUD;
		CAD = cAD;
		CNY = cNY;
		CZK = cZK;
		DKK = dKK;
		EUR = eUR;
		GBP = gBP;
		JPY = jPY;
		NOK = nOK;
		NZD = nZD;
		USD = uSD;
	}
	
	public String getCCY(String CCY){
		switch (CCY) {
		case "AUD":
			return AUD;
			
		case "CAD":
			return CAD;
			
		case "CNY":
			return CNY;
			
		case "CZK":
			return CZK;
			
		case "DKK":
			return DKK;
			
		case "EUR":
			return EUR;
			
		case "GBP":
			return GBP;
			
		case "JPY":
			return JPY;
			
		case "NOK":
			return NOK;
			
		case "NZD":
			return NZD;
			
		case "USD":
			return USD;

		default:
			return "";
		}
	}
	
	

}
