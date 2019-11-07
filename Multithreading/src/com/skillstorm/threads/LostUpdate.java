package com.skillstorm.threads;

public class LostUpdate {

	//static BankAccount account = new BankAccount();
	
	public static void main(String[] args) throws InterruptedException {
		// earner
		Thread earner = new Thread(()-> {
			BankAccount account = new BankAccount();
			for(int x=0;x<20000000;x++) {
				account.deposit(100);
			}
			System.out.println(account.balance);
		});
		earner.start();
		
		// spender
		Thread spender = new Thread(()-> {
			BankAccount account = new BankAccount();
			for(int x=0;x<20000000;x++) {
				account.withdraw(100);
			}
			System.out.println(account.balance);
		});
		spender.start();
		
		earner.join(); // main thread will pause until earner thread is done
		spender.join();
		
		//System.out.println(account.balance);
	}
	
}

class BankAccount {
	int balance = 0;
	
	public void deposit(int funds) {
		balance += funds;
	}
	
	public void withdraw(int funds) {
		balance -= funds;
	}
}
