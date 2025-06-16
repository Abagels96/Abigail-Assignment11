package com.codercampus.Assignment11.domain;

import java.util.Comparator;

public class TransactionUtility {

	
	public static Comparator<Transaction> byDate() {
		
		Comparator<Transaction> sortByDate= Comparator.comparing(Transaction::getDate);
		System.out.println(sortByDate);
		return sortByDate;
	}

}
