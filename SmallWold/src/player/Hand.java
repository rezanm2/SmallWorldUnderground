package player;

import java.io.Serializable;
/**
 * Dit is de class hand, deze houdt bij hoeveel tokens de speler op het moment heeft en hoeveel silverHammers hij heeft.
 * 
 * @author Groep13
 *
 */
public class Hand implements Serializable
{
	private int currentTokens;
	private int silverHammers;
	private int declineTokens;


	/**
	 * Maakt een lege hand aan.
	 */
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
