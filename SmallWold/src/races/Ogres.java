package races;

public class Ogres extends Race
{
	public Ogres()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		tokenType = "Ogres";
		traitText = "It takes one less token to conquer a region (minimum of one)";
	}

	@Override
	public void useTrait()
	{

	}
}
