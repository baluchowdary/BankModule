package com.kollu.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Bank_Details")
public class Bank {
	
	@Id
	@GenericGenerator(name = "Bank_Id_id", strategy = "com.kollu.bank.util.BankIdGenerator")
	@GeneratedValue(generator = "Bank_Id_id")  
	@Column(name="Bank_Id")
	private long bankId;
	
	@Column(name="Bank_Name")
	@NotBlank(message = "Bank Name is mandatory")
	private String bankName;
	
	@Column(name="Bank_IFSC_Code")
	@NotBlank(message = "Bank IFSC Code is mandatory")
	private String bankIfscCode;
	
	@Column(name="Bank_Branch_Address")
	@NotBlank(message = "Bank Branch Address is mandatory")
	private String bankBranchAddress;
	
	@Column(name="BankPooling_AccountNumber")
	@NotBlank(message = "Bank Pool Account no is mandatory")
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
		return "Bank [bankName=" + bankName + ", bankIfscCode=" + bankIfscCode + ", bankBranchAddress="
				+ bankBranchAddress + ", bankPoolingAccountNumber=" + bankPoolingAccountNumber + "]";
	}
	

}
