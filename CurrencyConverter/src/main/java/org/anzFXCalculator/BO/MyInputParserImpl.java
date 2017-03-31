package org.anzFXCalculator.BO;

import java.math.BigDecimal;
import java.util.Map;

import org.anzFXCalculator.domainData.CurrencyMatrixMap;
import org.anzFXCalculator.main.CurrencyConverter;
import org.anzFXCalculator.model.CurrencyMatrix;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

public class MyInputParserImpl implements InputParser {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);
	CurrencyMatrixMap matrix = new CurrencyMatrixMap();
	
	private Boolean validateInput(String[] inputArr){
		try {
			if(inputArr.length != 4) {
				throw new Exception("ERROR !!!! Invalid Input Format! Try Again, please refer to Sample Format");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			logger.debug(ex.getMessage());
			return false;
		}
		
		try {
			new BigDecimal(inputArr[1]);
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public CurrencyUnit parseInput(String userInput) {
		logger.debug("Parsing the User Input");
		String[] inputArr = userInput.split(" ");
		
		if(!validateInput(inputArr)) {
			return null;
		}
				
		String sourceCCY = inputArr[0].toUpperCase();
		String destCCY = inputArr[3].toUpperCase();
		BigDecimal amtToBeConverted = new BigDecimal(inputArr[1]);
		CurrencyMatrix currencyMatrix=null;
		String ccyStrategy=null;
		
		Map<String, CurrencyMatrix> ccyMatrixMap = matrix.getCcyMatrixMap();
		try {
			currencyMatrix = ccyMatrixMap.get(sourceCCY);
			if(currencyMatrix == null) {
				throw new Exception("OUTPUT IS --> Unable to find rate for " + sourceCCY + "/" + destCCY);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			logger.debug(ex.getMessage());
			return null;
		}
		
		try {
			ccyStrategy = currencyMatrix.getCCY(destCCY);
			if(ccyStrategy.trim().equals("") || ccyStrategy == null) {
				throw new Exception("OUTPUT IS --> Unable to find rate for " + sourceCCY + "/" + destCCY);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			logger.debug(ex.getMessage());
			return null;
		}		
		
		CurrencyUnit ccyObj = new CurrencyUnit(
				sourceCCY,
				destCCY,
				amtToBeConverted,
				ccyStrategy);
		
		return ccyObj;
	}

}
