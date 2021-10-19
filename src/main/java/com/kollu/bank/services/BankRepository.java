package com.kollu.bank.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kollu.bank.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
