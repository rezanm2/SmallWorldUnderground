package races;

public class Mummies extends Race
{
	public Mummies()
	{
		amountOfTokens = 10;
		maxTokens = 12;
		tokenType = "Mummies";
		traitText = "It takes 1 extra mummy to conquer a region.";
	}

	@Override
	public void useTrait()
	{

	}
}
