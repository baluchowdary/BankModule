package com.kollu.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Details")
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="Bank_Id")
	private long bankId;
	
	@Column(name="Bank_Name")
	private String bankName;
	
	@Column(name="Bank_IFSC_Code")
	private String bankIfscCode;
	
	@Column(name="Bank_Branch_Address")
	private String bankBranchAddress;
	
	@Column(name="BankPooling_AccountNumber")
	private String bankPoolingAccountNumber;

	public Bank() {
	}
		
	public Bank(String bankName, String bankIfscCode, String bankBranchAddress,
			String bankPoolingAccountNumber) {
		this.bankName = bankName;
		this.bankIfscCode = bankIfscCode;
		this.bankBranchAddress = bankBranchAddress;
		this.bankPoolingAccountNumber = bankPoolingAccountNumber;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBankBranchAddress() {
		return bankBranchAddress;
	}

	public void setBankBranchAddress(String bankBranchAddress) {
		this.bankBranchAddress = bankBranchAddress;
	}

	public String getBankPoolingAccountNumber() {
		return bankPoolingAccountNumber;
	}

	public void setBankPoolingAccountNumber(String bankPoolingAccountNumber) {
		this.bankPoolingAccountNumber = bankPoolingAccountNumber;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankIfscCode=" + bankIfscCode + ", bankBranchAddress="
				+ bankBranchAddress + ", bankPoolingAccountNumber=" + bankPoolingAccountNumber + "]";
	}
	

}
