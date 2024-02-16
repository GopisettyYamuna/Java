package banking;

public class ConsumerAccount  extends Account{
	private Person AccountHolder;
	public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
		super(person,accountNumber,pin,currentBalance);
		this.AccountHolder=person;
		// complete the function
	}
}
