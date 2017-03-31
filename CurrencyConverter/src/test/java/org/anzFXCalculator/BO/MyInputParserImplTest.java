package org.anzFXCalculator.BO;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.anzFXCalculator.BO.InputParser;
import org.anzFXCalculator.BO.MyInputParserImpl;
import org.anzFXCalculator.model.CurrencyUnit;
import org.junit.Test;

public class MyInputParserImplTest {

	@Test
	public void testParseInputAUD2USD() {
		String input = "AUD 100.00 in USD";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit exp_ccyObj = new CurrencyUnit("AUD", "USD", new BigDecimal("100.00"),"D");
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertEquals(exp_ccyObj.getSourceCCY(), act_ccyObj.getSourceCCY());
		assertEquals(exp_ccyObj.getDestCCY(), act_ccyObj.getDestCCY());
		assertEquals(exp_ccyObj.getAmount(), act_ccyObj.getAmount());
		assertEquals(exp_ccyObj.getCCYStrategy(), act_ccyObj.getCCYStrategy());
	}
	
	@Test
	public void testParseInputUSD2AUD() {
		String input = "USD 100.00 in AUD";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit exp_ccyObj = new CurrencyUnit("USD", "AUD", new BigDecimal("100.00"),"Inv");
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertEquals(exp_ccyObj.getSourceCCY(), act_ccyObj.getSourceCCY());
		assertEquals(exp_ccyObj.getDestCCY(), act_ccyObj.getDestCCY());
		assertEquals(exp_ccyObj.getAmount(), act_ccyObj.getAmount());
		assertEquals(exp_ccyObj.getCCYStrategy(), act_ccyObj.getCCYStrategy());
	}
	
	@Test
	public void testParseInputUSD2USD() {
		String input = "USD 100.00 in USD";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit exp_ccyObj = new CurrencyUnit("USD", "USD", new BigDecimal("100.00"),"1:1");
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertEquals(exp_ccyObj.getSourceCCY(), act_ccyObj.getSourceCCY());
		assertEquals(exp_ccyObj.getDestCCY(), act_ccyObj.getDestCCY());
		assertEquals(exp_ccyObj.getAmount(), act_ccyObj.getAmount());
		assertEquals(exp_ccyObj.getCCYStrategy(), act_ccyObj.getCCYStrategy());
	}
	
	@Test
	public void testParseInputAUD2JPY() {
		String input = "AUD 100.00 in JPY";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit exp_ccyObj = new CurrencyUnit("AUD", "JPY", new BigDecimal("100.00"),"USD");
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertEquals(exp_ccyObj.getSourceCCY(), act_ccyObj.getSourceCCY());
		assertEquals(exp_ccyObj.getDestCCY(), act_ccyObj.getDestCCY());
		assertEquals(exp_ccyObj.getAmount(), act_ccyObj.getAmount());
		assertEquals(exp_ccyObj.getCCYStrategy(), act_ccyObj.getCCYStrategy());
	}
	
	@Test
	public void testParseInputKRW2FJD() {
		String input = "KRW 1000.00 in FJD";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertNull(act_ccyObj);
	}
	
	@Test
	public void testParseInputGarbage() {
		String input = "Some Garbage Input value";
		InputParser myParser = new MyInputParserImpl();
		CurrencyUnit act_ccyObj = myParser.parseInput(input);
		assertNull(act_ccyObj);
	}

}
