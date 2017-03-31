package org.anzFXCalculator.model;

import java.math.BigDecimal;

/**
 * Domain Object representing the Input of FXCalculator program
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CurrencyUnit {
	private String sourceCCY;
	private String destCCY;
	private BigDecimal amount;
	private String strategy;

	public CurrencyUnit(String sourceCCY, String destCCY, BigDecimal amount, String crossCCY) {
		this.sourceCCY = sourceCCY;
		this.destCCY = destCCY;
		this.amount = amount;
		this.strategy = crossCCY;
	}
	
	public String getCCYStrategy(){
		return strategy;
	}

	public String getSourceCCY() {
		return sourceCCY;
	}

	public String getDestCCY() {
		return destCCY;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "CurrencyUnit [sourceCCY=" + sourceCCY + ", destCCY=" + destCCY + ", amount=" + amount + "]";
	}
}
