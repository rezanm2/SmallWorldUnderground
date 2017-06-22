package player;

import java.io.Serializable;

public class Hand implements Serializable
{
	private int currentTokens;
	private int silverHammers;
	private int declineTokens;


	public Hand(){};

	public void setCurrentTokens(int currentTokens)
	{
		this.currentTokens = currentTokens;
	}

	public int getDeclineTokens() {
		return declineTokens;
	}

	public void setDeclineTokens(int declineTokens) {
		this.declineTokens = declineTokens;
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
