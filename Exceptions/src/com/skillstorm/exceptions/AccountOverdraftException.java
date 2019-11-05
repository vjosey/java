package com.skillstorm.exceptions;

public class AccountOverdraftException extends BankException {
	public double getOverdraftAmount() {
		return 100.00;
	}
}
