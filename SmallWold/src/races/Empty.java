package races;

public class Empty extends Race
{

	public Empty()
	{
		amountOfTokens = 0;
		maxTokens = 0;
		tokenType = "Empty   ";
		traitText = "There is no race selected.";
	}

	@Override
	public void useTrait()
	{

	}
}
