
public class CreditCard extends Card{
	private double mCardLimit;

	public CreditCard(String name, String brand, double limit){
		super(name, brand);
		mCardLimit = limit;
	}
}
