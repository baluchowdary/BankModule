package com.kollu.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kollu.bank.model.Bank;
import com.kollu.bank.services.BankRepository;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;
	
/*Fetch All Bank details*/
	
	@GetMapping("/getAllBanks")
	public ResponseEntity<List<Bank>> getBankDetails(){
		System.out.println("getBankDetails method");
		try {
			
		List<Bank> banks = new ArrayList<Bank>();  
		bankRepository.findAll().forEach(banks::add);
		
		if (banks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(banks, HttpStatus.OK); 
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*Save Bank details*/
	
	@PostMapping("/savebanks")
	public ResponseEntity<Bank> saveBankDetails(@RequestBody Bank bank) {
		try {
			System.out.println("saveBankDetails method");
			Bank bankObj = bankRepository
					.save(new Bank(bank.getBankName(), bank.getBankIfscCode(), bank.getBankBranchAddress(), bank.getBankPoolingAccountNumber()));
			
			return new ResponseEntity<>(bankObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*Update Bank details based on {bankid}*/
	
	@PutMapping("/updatebankdetails/{bankId}")
	public ResponseEntity<Bank> updateBankDetails(@PathVariable("bankId") long bankId, @RequestBody Bank bank) {
		System.out.println("updateBankDetails");
		
		Optional<Bank> bankDetailsData = bankRepository.findById(bankId);

		if (bankDetailsData.isPresent()) {
			Bank bankObj = bankDetailsData.get();
			bankObj.setBankName(bank.getBankName()); 
			bankObj.setBankIfscCode(bank.getBankIfscCode());
			bankObj.setBankBranchAddress(bank.getBankBranchAddress()); 
			bankObj.setBankPoolingAccountNumber(bank.getBankPoolingAccountNumber()); 
			
			return new ResponseEntity<>(bankRepository.save(bankObj), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
/*Delete bank based on {id}*/
	
	@DeleteMapping("/{bankId}")
	public ResponseEntity<HttpStatus> deleteBankDetails(@PathVariable("bankId") long bankId) {
		try {
			System.out.println("deleteBankDetails");
			bankRepository.deleteById(bankId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*Deleting all the Banks data */
	
	@DeleteMapping("/deleteallbanks")
	public ResponseEntity<HttpStatus> deleteAllBanksDetails() {
		try {
			System.out.println("deleteAllBanksDetails");
			bankRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}