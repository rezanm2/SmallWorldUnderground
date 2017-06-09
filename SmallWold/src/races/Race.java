package races;

import main.Ammy;
import playBoard.Map;
import player.Player;

public abstract class Race
{
	protected int amountOfTokens;
	protected int maxTokens;
	protected String name;
	protected String traitText;
	protected Player activePlayer;
	protected Map map;
	protected int countCoins;

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}

	public abstract void processAbility(Ammy ammy);

	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}

	public void setMaxTokens(int maxTokens)
	{
		this.maxTokens = maxTokens;
	}

	public int getMaxTokens()
	{
		return maxTokens;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setTraitText(String traitText)
	{
		this.traitText = traitText;
	}
	public String getTraitText()
	{
		return traitText;
	}
}

