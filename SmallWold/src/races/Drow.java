package races;

public class Drow extends Race
{

	public Drow(String name, int amountOfTokens, int maxTokens)
	{
		super(name, amountOfTokens, maxTokens);
		traitText = "+1 Coin for each terrain that isn't sharing borders with non-drow.";
	}

}
