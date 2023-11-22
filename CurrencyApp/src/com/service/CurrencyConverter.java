package com.service;

import java.io.*;
import java.util.*;

public class CurrencyConverter {
	private static Map<String, Double> exchangeRates;
	//private static Map<String, String> supportCurrency;
	private static Map<String, Double> History;
    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
    
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.74);
        exchangeRates.put("INR", 75.0);
        
        History=new HashMap<String, Double>();
        
    }
    
//    public void SupportCurrency() {
//    	supportCurrency=new HashMap<String, String>();
//    	supportCurrency.put("USD", "United States Dollar");
//    	supportCurrency.put("EUR", "EURO");
//    	supportCurrency.put("GBP", "British Pound Sterling");
//    	supportCurrency.put("INR", "India Rupess ");
//    
//    }
//    
//   public void displaySupportCurrency() {
//	   for(Map.Entry<String, String>entry:supportCurrency.entrySet()) {
//		   System.out.println(entry.getKey()+":"+entry.getValue());
//	   }
//   }
		

    public void displayExchangeRates() {
        System.out.println("Exchange Rates:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency + ": " + exchangeRates.get(currency));
        }
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        double convertedAmount = amount * (toRate / fromRate);
        //History//
        History.put(fromCurrency + " to " + toCurrency, convertedAmount);
        return convertedAmount;
    }
    
    public void displayConversionHistory() {
        System.out.println("Conversion History:");
        for (String history : History.keySet()) {
            System.out.println(history + ": " + History.get(history));
        }
    }
    
    public void saveToHistory() {
    	try {
			FileWriter fw=new FileWriter("History_File.txt");
			for (String history : History.keySet()) {
	            fw.write(history + ": " + History.get(history));
	            fw.close();
	        }
			System.out.println("Data will be save in fill.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
