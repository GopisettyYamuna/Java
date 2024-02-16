package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	private Long accountNumber;
	private Bank bank;
	private int attemptedPin;
	 private double balance;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		this.bank = bank;
        this.accountNumber = accountNumber;
        this.attemptedPin = attemptedPin;
	
        if (!bank.authenticateUser(accountNumber, attemptedPin)) {
            throw new Exception("Invalid PIN");
        }
        this.balance = bank.getBalance(accountNumber);
	}

	public double getBalance() {
		// complete the function
        return balance;
	}

	public void credit(double amount) {
		// complete the function
		balance += amount;
        bank.credit(accountNumber, amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if (balance >= amount) {
            balance -= amount;
            bank.debit(accountNumber, amount);
            return true;
        }
        return false;
    }
	
}
