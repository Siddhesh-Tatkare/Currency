package com.user;
import java.util.*;

import com.config.HibernateUtil;
import com.model.Currency;
import org.hibernate.*;
import com.service.*;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		

		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		
		Currency obj=new Currency();
		System.out.println("Enter Id:");
		obj.setId(sc.nextInt());
		System.out.println("Enter Amount amountToconver:");
		obj.setAmount(sc.nextDouble());
		System.out.println("Enter fromCurrent ");
		obj.setFromCurrency(sc.next().toUpperCase());
		System.out.println("Enter toCurrency  ");
		obj.setToCurrency(sc.next().toUpperCase());
		
		ss.save(obj);
		tt.commit();
		
		CurrencyConverter c=new CurrencyConverter();
		for(;;) {
		System.out.println("Menu:");
		System.out.println("1.Display exchange rates\n2.Perform Currency Conversion\n3.DisplayHistory\n4.SaveHistory.\n5.Exits");
		System.out.println("Enter your choice:");
		int no=sc.nextInt();
		switch(no) {
		
		
		case 1:	c.displayExchangeRates();
				break;
				
		case 2:	
		      
		        double amountToConvert=obj.getAmount();
		        String fromCurrency=obj.getFromCurrency();
		        String toCurrency = obj.getToCurrency(); 
		        
		        double convertedAmount = c.convert(amountToConvert, fromCurrency, toCurrency);
		        System.out.println(amountToConvert + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
		        break;
		        
		case 3:	
				c.displayConversionHistory();
				break;
				
		case 4:
				c.saveToHistory();
				break;
				
		case 5:
				System.out.println("Enter 0 user will be exits:");
				if(sc.nextInt()==0) {
					System.out.println("User exits:");
				}
				break;
		
		default:
				System.out.println("Invaild:");
		}
		}
    }
}