package com.codercampus.Assignment11.web;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.domain.TransactionUtility;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired 
	TransactionService service;
	
//	@GetMapping("/transactionsDemo")
//		public String getTransactionsDemo() {
//			return "transactions";
//		}
//	

	
	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
	List<Transaction> transactions=	service.importTransactions();
		model.put("allTransactions", transactions);
		
		return "transactionsView";
		
	}
	
	
	
	
	@GetMapping("/transactions/{transactionId}")
	
	public String retrieveSpecificTransaction(ModelMap model, @PathVariable Long transactionId) {

		Optional<Transaction> specificTransaction= service.findTransactionById(transactionId);
		
		
		if(specificTransaction.isPresent()) {
		model.put("specificTransaction", specificTransaction.get());}
		else {
			return "Error message";
		}
	
		return "specific";
		
		
		
		
		
		
	}
	
}
 