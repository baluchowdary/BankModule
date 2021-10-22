package com.kollu.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	private BankRepository bankRepository;
	
/*Fetch All Bank details*/
	
	@GetMapping("/getAllBanks")
	public ResponseEntity<List<Bank>> getBankDetails(){
		System.out.println("Console:: BankController - getBankDetails method");
		logger.info("BankController - getBankDetails method"); 
		try {
			
		List<Bank> banks = new ArrayList<Bank>();  
		bankRepository.findAll().forEach(banks::add);
		
		System.out.println("Console:: BankController - getBankDetails - banks data size ::"+banks.size());
		logger.debug("BankController - getBankDetails - banks data ::"); 
		
		if (banks.isEmpty()) {
			System.out.println("Console:: BankController - getBankDetails - banks data size ::"+banks.size());
			logger.debug("BankController - getBankDetails - banks data ::"); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(banks, HttpStatus.OK); 
		
	} catch (Exception e) {
		System.out.println("Console:: BankController - getBankDetails - Error ::" +e.getMessage());
		logger.error("BankController - getBankDetails - Error :: " +e.getMessage()); 
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
/*	Get the bank details by using {bankId}*/
	
	@GetMapping("/{bankId}")
	public ResponseEntity<Bank> getBankById(@PathVariable("bankId") long id) {
		System.out.println("Console:: BankController - getBankById method");
		logger.info("BankController - getBankById method");
		logger.info("BankController - getBankById id :: "+id); 
		
		Optional<Bank> banksData = bankRepository.findById(id);

		if (banksData.isPresent()) {
			System.out.println("Console:: BankController - getBankById banksData is present ::"+banksData.isPresent());
			logger.info("BankController - getBankById banksData is present ::"+banksData.isPresent());
			return new ResponseEntity<>(banksData.get(), HttpStatus.OK);
		} else {
			System.out.println("Console:: BankController - getBankById banksData is present ::"+banksData.isPresent());
			logger.info("BankController - getBankById banksData is present ::"+banksData.isPresent());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
/*Save Bank details*/
	
	@PostMapping("/savebanks")
	public ResponseEntity<Bank> saveBankDetails(@RequestBody Bank bank) {
		System.out.println("Console:: BankController - saveBankDetails method");
		logger.info("BankController - saveBankDetails method");
		
		try {
			Bank bankObj = bankRepository
					.save(new Bank(bank.getBankName(), bank.getBankIfscCode(), bank.getBankBranchAddress(), bank.getBankPoolingAccountNumber()));
			
			System.out.println("Console:: BankController - saveBankDetails bankObj ::"+bankObj);
			logger.info("BankController - saveBankDetails bankObj ::"+bankObj);
			return new ResponseEntity<>(bankObj, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Console:: BankController - saveBankDetails - Error ::" +e.getMessage());
			logger.error("BankController - saveBankDetails - Error :: " +e.getMessage()); 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*Update Bank details based on {bankid}*/
	
	@PutMapping("/updatebankdetails/{bankId}")
	public ResponseEntity<Bank> updateBankDetails(@PathVariable("bankId") long bankId, @RequestBody Bank bank) {
		System.out.println("Console:: BankController - updateBankDetails method");
		logger.info("BankController - updateBankDetails method");
		logger.info("BankController - updateBankDetails bankId ::" +bankId);
		
		Optional<Bank> bankDetailsData = bankRepository.findById(bankId);

		if (bankDetailsData.isPresent()) {
			Bank bankObj = bankDetailsData.get();
			bankObj.setBankName(bank.getBankName()); 
			bankObj.setBankIfscCode(bank.getBankIfscCode());
			bankObj.setBankBranchAddress(bank.getBankBranchAddress()); 
			bankObj.setBankPoolingAccountNumber(bank.getBankPoolingAccountNumber()); 
			
			System.out.println("Console:: BankController - updateBankDetails bankDetailsData ::"+bankDetailsData.isPresent());
			logger.info("BankController - updateBankDetails bankDetailsData ::"+bankDetailsData.isPresent());
			
			return new ResponseEntity<>(bankRepository.save(bankObj), HttpStatus.OK);
		} else {
			System.out.println("Console:: BankController - updateBankDetails bankDetailsData ::"+bankDetailsData.isPresent());
			logger.info("BankController - updateBankDetails bankDetailsData ::"+bankDetailsData.isPresent());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
/*Delete bank based on {id}*/
	
	@DeleteMapping("/{bankId}")
	public ResponseEntity<HttpStatus> deleteBankDetails(@PathVariable("bankId") long bankId) {
		System.out.println("Console:: BankController - deleteBankDetails method");
		logger.info("BankController - deleteBankDetails method");
		logger.info("BankController - deleteBankDetails bankId ::" +bankId);
		
		try {
			
			bankRepository.deleteById(bankId);
			System.out.println("Console:: BankController - deleteBankDetails deleted");
			logger.info("BankController - deleteBankDetails deleted");
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println("Console:: BankController - deleteBankDetails - Error ::" +e.getMessage());
			logger.error("BankController - deleteBankDetails - Error :: " +e.getMessage()); 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*Deleting all the Banks data */
	
	@DeleteMapping("/deleteallbanks")
	public ResponseEntity<HttpStatus> deleteAllBanksDetails() {
		System.out.println("Console:: BankController - deleteAllBanksDetails method");
		logger.info("BankController - deleteAllBanksDetails method");
		try {
			bankRepository.deleteAll();
			System.out.println("Console:: BankController - deleteAllBanksDetails deleted");
			logger.info("BankController - deleteAllBanksDetails deteled ");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println("Console:: BankController - deleteAllBanksDetails - Error ::" +e.getMessage());
			logger.error("BankController - deleteAllBanksDetails - Error :: " +e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}