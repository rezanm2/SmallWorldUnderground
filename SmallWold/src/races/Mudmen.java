package races;

public class Mudmen extends Race
{
	public Mudmen()
	{
		amountOfTokens = 5;
		maxTokens = 12;
		tokenType = "Mudmen";
		traitText = "Get a new mudmen token at the start of Conquest for each mud region.";
	}

	@Override
	public void useTrait()
	{

	}
}
