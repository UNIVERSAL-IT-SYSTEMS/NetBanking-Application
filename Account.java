package com.i2i.bank.model;

public class Account {
    private int id;
    private String accountNumber;
    private String userId;
    private String IFSCode;
    private String branchName;
    private double balance;
    private String accountType;
    
    
    public Account(int id, String accountNumber, String branchName, double balance, String accountType) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.branchName = branchName;
		this.balance = balance;
		this.accountType = accountType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBranchId() {
		return IFSCode;
	}
	public void setBranchId(String branchId) {
		this.IFSCode = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
}
