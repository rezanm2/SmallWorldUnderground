package races;

public class Drow extends Race
{

	public Drow()
	{
		amountOfTokens = 4;
		maxTokens = 9;
		tokenType = "Drow    ";
		traitText = "+1 Coin for each terrain that isn't sharing borders with non-drow.";
	}

	@Override
	public void useTrait()
	{

	}
}
