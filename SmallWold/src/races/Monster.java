package races;

public class Monster extends Race
{
	public Monster()
	{
		amountOfTokens = 2;
		maxTokens = 14;
		tokenType = "Monsters";
		traitText = "When conquered, take a special event thingie thing thing";
	}
	@Override
	public void useTrait()
	{

	}
}
