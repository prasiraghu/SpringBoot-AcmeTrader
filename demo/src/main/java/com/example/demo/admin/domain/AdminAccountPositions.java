package com.example.demo.admin.domain;

public class AdminAccountPositions {
	private String accountNumber;
	private String tickerSymbol;
	private String securityNum;
	private String securityDesc;
	private int quantity;
	private int lastPrice;
	private int currentPosValue;

	/**
	 * 
	 */
	public AdminAccountPositions() {
		super();
	}

	/**
	 * @param accountNumber
	 * @param tickerSymbol
	 * @param securityNum
	 * @param securityDesc
	 * @param quantity
	 * @param lastPrice
	 * @param currentPosValue
	 */
	public AdminAccountPositions(String accountNumber, String tickerSymbol, String securityNum, String securityDesc,
			int quantity, int lastPrice, int currentPosValue) {
		super();
		this.accountNumber = accountNumber;
		this.tickerSymbol = tickerSymbol;
		this.securityNum = securityNum;
		this.securityDesc = securityDesc;
		this.quantity = quantity;
		this.lastPrice = lastPrice;
		this.currentPosValue = currentPosValue;
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
	 * @return the tickerSymbol
	 */
	public String getTickerSymbol() {
		return tickerSymbol;
	}

	/**
	 * @param tickerSymbol the tickerSymbol to set
	 */
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	/**
	 * @return the securityNum
	 */
	public String getSecurityNum() {
		return securityNum;
	}

	/**
	 * @param securityNum the securityNum to set
	 */
	public void setSecurityNum(String securityNum) {
		this.securityNum = securityNum;
	}

	/**
	 * @return the securityDesc
	 */
	public String getSecurityDesc() {
		return securityDesc;
	}

	/**
	 * @param securityDesc the securityDesc to set
	 */
	public void setSecurityDesc(String securityDesc) {
		this.securityDesc = securityDesc;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the lastPrice
	 */
	public int getLastPrice() {
		return lastPrice;
	}

	/**
	 * @param lastPrice the lastPrice to set
	 */
	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * @return the currentPosValue
	 */
	public int getCurrentPosValue() {
		return currentPosValue;
	}

	/**
	 * @param currentPosValue the currentPosValue to set
	 */
	public void setCurrentPosValue(int currentPosValue) {
		this.currentPosValue = currentPosValue;
	}

	@Override
	public String toString() {
		return "AdminAccountPositions [accountNumber=" + accountNumber + ", tickerSymbol=" + tickerSymbol
				+ ", securityNum=" + securityNum + ", securityDesc=" + securityDesc + ", quantity=" + quantity
				+ ", lastPrice=" + lastPrice + ", currentPosValue=" + currentPosValue + "]";
	}

}
