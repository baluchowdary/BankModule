package com.kollu.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Customer_Bank_Details")
public class CustomerBank {
	
	@Id
	@GenericGenerator(name = "Cust_Bank_Id_id", strategy = "com.kollu.bank.util.CustomerBankIdGenerator")
	@GeneratedValue(generator = "Cust_Bank_Id_id")  
	@Column(name="CustBank_Id")
	private long customerBankId;
	
	
	
	@Column(name="Bank_CustId")
	@NotNull(message = "Bank Customer Id is mandatory")
	private long bankCustId;

	@Column(name="Bank_CustFirstName")
	@NotBlank(message = "Bank Customer First Name is mandatory")
	private String bankCustFirstName;
	
	@Column(name="Bank_CustLastName")
	@NotBlank(message = "Bank Customer Last Name is mandatory")
	private String bankCustLastName; 
	
	@Column(name="Bank_CustMobileNumber")
	@NotBlank(message = "Bank Customer Mobile no is mandatory")
	private String bankCustMobileNumber;
	
	@Column(name="Bank_CustGender")
	@NotBlank(message = "Bank Customer Gender type is mandatory")
	private String bankCustGender;
	
	@Column(name="Bank_CustAddress")
	@NotBlank(message = "Bank Customer Address is mandatory")
	private String bankCustAddress;
	
	
	
	@Column(name="Customer_BankId")
	@NotNull(message = "Customer Bank Id is mandatory")
	private long custBankId;
	
	@Column(name="CustomerBank_Name")
	@NotBlank(message = "Customer Bank Name is mandatory")
	private String custBankName;
	
	@Column(name="CustomerBank_IfscCode")
	@NotBlank(message = "Customer Bank IFSC code is mandatory")
	private String custBankIfscCode;
	
	@Column(name="CustomerBank_BranchAddress")
	@NotBlank(message = "Customer Bank Branch Address is mandatory")
	private String custBankBranchAddress;
	
	@Column(name="CustomerBank_AccountNo")
	//@Size(max=11)
	@NotBlank(message = "Customer Bank Account no is mandatory")
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

	/*public long getCustomerBankId() {
		return customerBankId;
	}

	public void setCustomerBankId(long customerBankId) {
		this.customerBankId = customerBankId;
	}
*/
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
		return "CustomerBank [bankCustId=" + bankCustId + ", bankCustFirstName=" + bankCustFirstName
				+ ", bankCustLastName=" + bankCustLastName + ", bankCustMobileNumber=" + bankCustMobileNumber
				+ ", bankCustGender=" + bankCustGender + ", bankCustAddress=" + bankCustAddress + ", custBankId="
				+ custBankId + ", custBankName=" + custBankName + ", custBankIfscCode=" + custBankIfscCode
				+ ", custBankBranchAddress=" + custBankBranchAddress + ", custBankAccountNo=" + custBankAccountNo + "]";
	}

}
