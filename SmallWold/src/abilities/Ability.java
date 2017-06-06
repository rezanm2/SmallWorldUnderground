package abilities;

import player.Player;

public abstract class Ability
{

	protected String type;
	protected String traitText;
	protected int amountOfTokens;
	protected boolean active;
	protected Player activePlayer;

	public Ability()
	{
	}

	public abstract void calculateAbility(Player activePlayer);

	public void setType(String name)
	{
		this.type = name;
	}
	public String getType()
	{
		return type;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public boolean getActive()
	{
		return active;
	}

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}
	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}
}
