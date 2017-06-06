package races;

public class Gnomes extends Race
{
	public Gnomes()
	{
		amountOfTokens = 6;
		maxTokens = 11;
		tokenType = "Gnomes";
		traitText = "Can't be targeted by any effects";
	}

	@Override
	public void useTrait()
	{

	}
}
