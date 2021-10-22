package com.kollu.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kollu.bank.exception.RecordNotFoundException;
import com.kollu.bank.model.CustomerBank;
import com.kollu.bank.services.CustomerBankRepository;

@RestController
@RequestMapping("/custBank")
public class CustomerBankDetailsController {

	private Logger logger = LoggerFactory.getLogger(CustomerBankDetailsController.class);
	
	@Autowired
	private CustomerBankRepository customerBankRepository;
	
/*Save Customer Bank details*/
	
	@PostMapping("/savecustbankdetails")
	public ResponseEntity<CustomerBank> saveCustBankDetails(@Valid @RequestBody CustomerBank customerBank) {
		System.out.println("Console:: CustomerBankDetailsController - saveCustBankDetails method");
		logger.info("CustomerBankDetailsController - saveCustBankDetails method");
		
		try {
			CustomerBank CustomerBankObj = customerBankRepository
					.save(new CustomerBank(customerBank.getBankCustId(), 
							customerBank.getBankCustFirstName(), customerBank.getBankCustLastName(), 
							customerBank.getBankCustMobileNumber(), customerBank.getBankCustGender(), customerBank.getBankCustAddress(),
							customerBank.getCustBankId(), customerBank.getCustBankName(), 
							customerBank.getCustBankIfscCode(), customerBank.getCustBankBranchAddress(), 
							customerBank.getCustBankAccountNo())); 
			
			System.out.println("Console:: CustomerBankDetailsController - saveCustBankDetails CustomerBankObj :: "+CustomerBankObj);
			logger.debug("CustomerBankDetailsController - saveCustBankDetails CustomerBankObj :: "+CustomerBankObj);
			
			return new ResponseEntity<>(CustomerBankObj, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Console:: CustomerBankDetailsController - saveCustBankDetails - Error ::" +e.getMessage());
			logger.error("CustomerBankDetailsController - saveCustBankDetails - Error :: " +e.getMessage());
			return new ResponseEntity<CustomerBank>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*Fetch All Customer Bank details*/
	
	@GetMapping("/getAllCustBankDetails")
	public ResponseEntity<List<CustomerBank>> getCustBankDetails(){
		System.out.println("Console:: CustomerBankDetailsController - getCustBankDetails method");
		logger.info("CustomerBankDetailsController - getCustBankDetails method");
		try {
			
		List<CustomerBank> customerBank = new ArrayList<CustomerBank>();  
		customerBankRepository.findAll().forEach(customerBank::add);
		
		if (customerBank.isEmpty()) {
			System.out.println("Console:: CustomerBankDetailsController - customerBank ::"+customerBank.size());
			logger.info("CustomerBankDetailsController - customerBank ::" +customerBank.size());
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new RecordNotFoundException("Customer Bank details not avilable.");
		}
		return new ResponseEntity<>(customerBank, HttpStatus.OK); 
		
	} catch (Exception e) {
		System.out.println("Console:: CustomerBankDetailsController - getCustBankDetails - Error ::" +e.getMessage());
		logger.error("CustomerBankDetailsController - getCustBankDetails - Error :: " +e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
/*	Get the customer bank details by using {bankId}*/
	
	@GetMapping("/{custBankId}")
	public ResponseEntity<CustomerBank> getBankById(@Valid @PathVariable("custBankId") long id) {
		System.out.println("Console:: CustomerBankDetailsController - getBankById method");
		logger.info("CustomerBankDetailsController - getBankById method");
		
		Optional<CustomerBank> custBanksData = customerBankRepository.findById(id);

		if (custBanksData.isPresent()) {
			System.out.println("Console:: CustomerBankDetailsController - getBankById custBanksData ispresent ::"+custBanksData.isPresent());
			logger.info("CustomerBankDetailsController - getBankById custBanksData ispresent ::"+custBanksData.isPresent());
			return new ResponseEntity<>(custBanksData.get(), HttpStatus.OK);
		} else {
			System.out.println("Console:: CustomerBankDetailsController - getBankById custBanksData ispresent ::"+custBanksData.isPresent());
			logger.info("CustomerBankDetailsController - getBankById custBanksData ispresent ::"+custBanksData.isPresent());
			throw new RecordNotFoundException("Provided customer bank id not avilable.");
		}
	}
	
/*	Get the customer bank details by using {bankId}*/
	
	@GetMapping("/bankCustById/{bankCustId}")
	public ResponseEntity<CustomerBank> getBankCustById(@Valid @PathVariable("bankCustId") long bankCustId) {
		
		System.out.println("Console:: CustomerBankDetailsController - getBankCustById method");
		logger.info("CustomerBankDetailsController - getBankCustById method");
		
		CustomerBank custBanksData = customerBankRepository.findByBankCustId(bankCustId); 

		if (custBanksData != null) {
			System.out.println("Console:: CustomerBankDetailsController - getBankCustById custBanksData :: "+custBanksData);
			logger.info("CustomerBankDetailsController - getBankCustById custBanksData ::"+custBanksData); 
			return new ResponseEntity<>(custBanksData, HttpStatus.OK); 
		} else {
			System.out.println("Console:: CustomerBankDetailsController - getBankCustById custBanksData :: "+custBanksData);
			logger.info("CustomerBankDetailsController - getBankCustById custBanksData ::"+custBanksData);
			throw new RecordNotFoundException("Provided customer bank id not avilable.");
		}
	}
	
/*	Get the customer bank details by using {bankId}*/
	
	@GetMapping("/bankCustByIdd/{bankCustId}")
	public ResponseEntity<CustomerBank> getBankCustByIdd(@Valid @PathVariable("bankCustId") long bankCustId) {
		System.out.println("Console:: CustomerBankDetailsController - getBankCustByIdd method");
		logger.info("CustomerBankDetailsController - getBankCustByIdd method"); 
		logger.info("CustomerBankDetailsController - getBankCustByIdd bankCustId ::" +bankCustId);
		
		CustomerBank custBanksData = customerBankRepository.findByBankCustId(bankCustId); 

		if (custBanksData != null) {
			System.out.println("Console:: CustomerBankDetailsController - getBankCustByIdd custBanksData :: "+custBanksData);
			logger.info("CustomerBankDetailsController - getBankCustByIdd custBanksData ::"+custBanksData); 
			return new ResponseEntity<>(custBanksData, HttpStatus.OK); 
		} else {
			System.out.println("Console:: CustomerBankDetailsController - getBankCustByIdd custBanksData :: "+custBanksData);
			logger.info("CustomerBankDetailsController - getBankCustByIdd custBanksData ::"+custBanksData);
			throw new RecordNotFoundException("Provided customer bank id not avilable.");
		}
		
	}
	
}
