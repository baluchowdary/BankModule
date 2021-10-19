package com.kollu.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kollu.bank.model.CustomerBank;
import com.kollu.bank.services.CustomerBankRepository;

@RestController
@RequestMapping("/custBank")
public class CustomerBankDetailsController {

	@Autowired
	private CustomerBankRepository customerBankRepository;
	
/*Save Customer Bank details*/
	
	@PostMapping("/savecustbankdetails")
	public ResponseEntity<CustomerBank> saveCustBankDetails(@RequestBody CustomerBank customerBank) {
		try {
			System.out.println("saveCustBankDetails method");
			CustomerBank CustomerBankObj = customerBankRepository
					.save(new CustomerBank(customerBank.getBankCustId(), 
							customerBank.getBankCustFirstName(), customerBank.getBankCustLastName(), 
							customerBank.getBankCustMobileNumber(), customerBank.getBankCustGender(), customerBank.getBankCustAddress(),
							customerBank.getCustBankId(), customerBank.getCustBankName(), 
							customerBank.getCustBankIfscCode(), customerBank.getCustBankBranchAddress(), 
							customerBank.getCustBankAccountNo())); 
			
			return new ResponseEntity<>(CustomerBankObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*Fetch All Customer Bank details*/
	
	@GetMapping("/getAllCustBankDetails")
	public ResponseEntity<List<CustomerBank>> getCustBankDetails(){
		System.out.println("getCustBankDetails method");
		try {
			
		List<CustomerBank> customerBank = new ArrayList<CustomerBank>();  
		customerBankRepository.findAll().forEach(customerBank::add);
		
		if (customerBank.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customerBank, HttpStatus.OK); 
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*	Get the customer bank details by using {bankId}*/
	
	@GetMapping("/{custBankId}")
	public ResponseEntity<CustomerBank> getBankById(@PathVariable("custBankId") long id) {
		System.out.println("getBankById method");
		Optional<CustomerBank> custBanksData = customerBankRepository.findById(id);

		if (custBanksData.isPresent()) {
			return new ResponseEntity<>(custBanksData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
/*	Get the customer bank details by using {bankId}*/
	
	@GetMapping("/bankCustById/{bankCustId}")
	public ResponseEntity<CustomerBank> getBankCustById(@PathVariable("bankCustId") long bankCustId) {
		System.out.println("getBankCustById method");
		CustomerBank custBanksData = customerBankRepository.findByBankCustId(bankCustId); 

		if (custBanksData != null) {
			return new ResponseEntity<>(custBanksData, HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
