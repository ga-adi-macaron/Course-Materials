
public class DebitCard extends Card{
	private double mAccountBalance;

	public DebitCard(String name, String brand, double balance){
		super(name,brand);
		mAccountBalance = balance;
	}
}
