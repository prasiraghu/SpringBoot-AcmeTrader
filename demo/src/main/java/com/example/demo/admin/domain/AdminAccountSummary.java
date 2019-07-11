package com.example.demo.admin.domain;

public class AdminAccountSummary {
	private String accountNumber;
	private String asOfDate;
	private int cashAvailable;

	/**
	 * 
	 */
	public AdminAccountSummary() {
		super();
	}

	/**
	 * @param accountNumber
	 * @param asOfDate
	 * @param cashAvailable
	 */
	public AdminAccountSummary(String accountNumber, String asOfDate, int cashAvailable) {
		super();
		this.accountNumber = accountNumber;
		this.asOfDate = asOfDate;
		this.cashAvailable = cashAvailable;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the asOfDate
	 */
	public String getAsOfDate() {
		return asOfDate;
	}

	/**
	 * @param asOfDate the asOfDate to set
	 */
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}

	/**
	 * @return the cashAvailable
	 */
	public int getCashAvailable() {
		return cashAvailable;
	}

	/**
	 * @param cashAvailable the cashAvailable to set
	 */
	public void setCashAvailable(int cashAvailable) {
		this.cashAvailable = cashAvailable;
	}

	@Override
	public String toString() {
		return "AdminAccountSummary [accountNumber=" + accountNumber + ", asOfDate=" + asOfDate + ", cashAvailable="
				+ cashAvailable + "]";
	}

}
