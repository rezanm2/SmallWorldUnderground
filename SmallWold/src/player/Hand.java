package player;

public class Hand
{
	private int currentTokens;
	private int silverHammers;


	public Hand(){};

	public void setCurrentTokens(int currentTokens)
	{
		this.currentTokens = currentTokens;
	}
	public int getCurrentTokens()
	{
		return currentTokens;
	}

	public void setSilverHammers(int silverHammers)
	{
		this.silverHammers = silverHammers;
	}

	public int getSilverHammers()
	{
		return silverHammers;
	}
}
