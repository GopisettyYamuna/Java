package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	 private Long accountNumberCounter;

	public Bank() {
		// complete the function
		 this.accounts = new LinkedHashMap<>();
		 this.accountNumberCounter = 1000L; 
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
	    Long accountNumber = generateAccountNumber();
		CommercialAccount account = new CommercialAccount(company,generateAccountNumber() , pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = generateAccountNumber(); 
		ConsumerAccount account = new ConsumerAccount(person,generateAccountNumber() , pin, startingDeposit); 
	        accounts.put(accountNumber, account);
	        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.validatePin(pin);
        }
        return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		 Account account = accounts.get(accountNumber);
	        if (account != null) {
	            account.creditAccount(amount);
	        }
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.debitAccount(amount);
        }
        return false;
	}
	 private Long generateAccountNumber() {
	        return accountNumberCounter++; // Increment counter and return the new account number
	        
	    }
}
