package com.kollu.bank.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kollu.bank.model.CustomerBank;

@Repository
public interface CustomerBankRepository extends JpaRepository<CustomerBank, Long> {

	@Query(value = "SELECT * FROM Customer_Bank_Details WHERE BANK_CUST_ID = ?1", nativeQuery = true)
	public CustomerBank findByBankCustId(long bankCustId);
	
	
}
