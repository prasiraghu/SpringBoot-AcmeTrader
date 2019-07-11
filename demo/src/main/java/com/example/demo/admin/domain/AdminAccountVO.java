package com.example.demo.admin.domain;

public class AdminAccountVO {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String accountNumber;
	private String traderId;

	/**
	 * 
	 */
	public AdminAccountVO() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param accountNumber
	 * @param traderId
	 */
	public AdminAccountVO(String firstName, String lastName, String email, String phoneNumber, String accountNumber,
			String traderId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.traderId = traderId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the traderId
	 */
	public String getTraderId() {
		return traderId;
	}

	/**
	 * @param traderId the traderId to set
	 */
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	@Override
	public String toString() {
		return "AdminAccountVO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + ", traderId=" + traderId + "]";
	}
}
