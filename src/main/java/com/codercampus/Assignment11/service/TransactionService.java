package com.codercampus.Assignment11.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service 
public class TransactionService {
	
	@Autowired
	TransactionRepository repo;
	
	public List<Transaction> importTransactions() {
		
		Comparator<Transaction> byDate=Comparator.comparing(Transaction::getDate);
		List<Transaction>sortedTransactions=repo.findAll().stream()
				                                        .sorted(byDate)
				                                        .collect(Collectors.toList());
		System.out.println(sortedTransactions);
		return sortedTransactions;
		 
		
	}
	
	public Optional<Transaction> findTransactionById(Long transactionId) {
		
		return repo.findById(transactionId);
		
		
	}

}
