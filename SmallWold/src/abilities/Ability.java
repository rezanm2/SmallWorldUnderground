package abilities;

import main.Ammy;
import player.Player;

public abstract class Ability
{
	protected int abilityIncome;
	protected String name;
	protected String traitText;
	protected int amountOfTokens;
	protected boolean active;
	protected Player activePlayer;

	public Ability()
	{
	}

	public abstract void processAbility(Player activePlayer);

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
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

	public int getAbilityIncome() {
		return abilityIncome;
	}
}
