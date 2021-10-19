package com.kollu.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Bank_Details")
public class CustomerBank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CustBank_Id")
	private long customerBankId;
	
	
	
	@Column(name="Bank_CustId")
	private long bankCustId;

	@Column(name="Bank_CustFirstName")
	private String bankCustFirstName;
	
	@Column(name="Bank_CustLastName")
	private String bankCustLastName; 
	
	@Column(name="Bank_CustMobileNumber")
	private String bankCustMobileNumber;
	
	@Column(name="Bank_CustGender")
	private String bankCustGender;
	
	@Column(name="Bank_CustAddress")
	private String bankCustAddress;
	
	
	
	@Column(name="Customer_BankId")
	private long custBankId;
	
	@Column(name="CustomerBank_Name")
	private String custBankName;
	
	@Column(name="CustomerBank_IfscCode")
	private String custBankIfscCode;
	
	@Column(name="CustomerBank_BranchAddress")
	private String custBankBranchAddress;
	
	@Column(name="CustomerBank_AccountNo")
	private String custBankAccountNo;

	public CustomerBank() {
	}

	public CustomerBank(long bankCustId, String bankCustFirstName, String bankCustLastName, String bankCustMobileNumber,
			String bankCustGender, String bankCustAddress, long custBankId, String custBankName,
			String custBankIfscCode, String custBankBranchAddress, String custBankAccountNo) {
		super();
		this.bankCustId = bankCustId;
		this.bankCustFirstName = bankCustFirstName;
		this.bankCustLastName = bankCustLastName;
		this.bankCustMobileNumber = bankCustMobileNumber;
		this.bankCustGender = bankCustGender;
		this.bankCustAddress = bankCustAddress;
		this.custBankId = custBankId;
		this.custBankName = custBankName;
		this.custBankIfscCode = custBankIfscCode;
		this.custBankBranchAddress = custBankBranchAddress;
		this.custBankAccountNo = custBankAccountNo;
	}

	public long getCustomerBankId() {
		return customerBankId;
	}

	public void setCustomerBankId(long customerBankId) {
		this.customerBankId = customerBankId;
	}

	public long getBankCustId() {
		return bankCustId;
	}

	public void setBankCustId(long bankCustId) {
		this.bankCustId = bankCustId;
	}

	public String getBankCustFirstName() {
		return bankCustFirstName;
	}

	public void setBankCustFirstName(String bankCustFirstName) {
		this.bankCustFirstName = bankCustFirstName;
	}

	public String getBankCustLastName() {
		return bankCustLastName;
	}

	public void setBankCustLastName(String bankCustLastName) {
		this.bankCustLastName = bankCustLastName;
	}

	public String getBankCustMobileNumber() {
		return bankCustMobileNumber;
	}

	public void setBankCustMobileNumber(String bankCustMobileNumber) {
		this.bankCustMobileNumber = bankCustMobileNumber;
	}

	public String getBankCustGender() {
		return bankCustGender;
	}

	public void setBankCustGender(String bankCustGender) {
		this.bankCustGender = bankCustGender;
	}

	public String getBankCustAddress() {
		return bankCustAddress;
	}

	public void setBankCustAddress(String bankCustAddress) {
		this.bankCustAddress = bankCustAddress;
	}

	public long getCustBankId() {
		return custBankId;
	}

	public void setCustBankId(long custBankId) {
		this.custBankId = custBankId;
	}

	public String getCustBankName() {
		return custBankName;
	}

	public void setCustBankName(String custBankName) {
		this.custBankName = custBankName;
	}

	public String getCustBankIfscCode() {
		return custBankIfscCode;
	}

	public void setCustBankIfscCode(String custBankIfscCode) {
		this.custBankIfscCode = custBankIfscCode;
	}

	public String getCustBankBranchAddress() {
		return custBankBranchAddress;
	}

	public void setCustBankBranchAddress(String custBankBranchAddress) {
		this.custBankBranchAddress = custBankBranchAddress;
	}

	public String getCustBankAccountNo() {
		return custBankAccountNo;
	}

	public void setCustBankAccountNo(String custBankAccountNo) {
		this.custBankAccountNo = custBankAccountNo;
	}

	@Override
	public String toString() {
		return "CustomerBank [customerBankId=" + customerBankId + ", bankCustId=" + bankCustId + ", bankCustFirstName="
				+ bankCustFirstName + ", bankCustLastName=" + bankCustLastName + ", bankCustMobileNumber="
				+ bankCustMobileNumber + ", bankCustGender=" + bankCustGender + ", bankCustAddress=" + bankCustAddress
				+ ", custBankId=" + custBankId + ", custBankName=" + custBankName + ", custBankIfscCode="
				+ custBankIfscCode + ", custBankBranchAddress=" + custBankBranchAddress + ", custBankAccountNo="
				+ custBankAccountNo + "]";
	}

}
