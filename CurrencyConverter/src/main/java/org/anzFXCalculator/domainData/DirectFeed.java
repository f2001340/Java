package org.anzFXCalculator.domainData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DirectFeed {
	public Map<String, BigDecimal> directFeedMap = new HashMap<String, BigDecimal>();

	/**
	 * Repository of Currency Pairs and Rates.
	 * This would generally come from Database Tables, but for Simplicity, we are hardcoding.
	 * 
	 * @author ADITYA MAJETY
	 * 
	 */
	public DirectFeed() {
		directFeedMap.put("AUDUSD", new BigDecimal("0.8371"));
		directFeedMap.put("CADUSD", new BigDecimal("0.8711"));
		directFeedMap.put("USDCNY", new BigDecimal("6.1715"));
		directFeedMap.put("EURUSD", new BigDecimal("1.2315"));
		directFeedMap.put("GBPUSD", new BigDecimal("1.5683"));
		directFeedMap.put("NZDUSD", new BigDecimal("0.7750"));
		directFeedMap.put("USDJPY", new BigDecimal("119.95"));
		directFeedMap.put("EURCZK", new BigDecimal("27.6028"));
		directFeedMap.put("EURDKK", new BigDecimal("7.4405"));
		directFeedMap.put("EURNOK", new BigDecimal("8.6651"));
	}

	public Map<String, BigDecimal> getDirectFeed() {
		return directFeedMap;
	}
}
