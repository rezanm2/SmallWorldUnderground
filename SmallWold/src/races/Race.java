package races;

import java.io.Serializable;

import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Deze class is de hoofdclass voor alle races die er zijn.
 * Het bevat het aantal tokens en maxtokens, de naam, traittext, raceinkomens.
 *
 * @author  Jeroen Zandvliet, Wim van der Putten
 */
public abstract class Race implements Serializable
{
	protected int amountOfTokens;
	protected int maxTokens;
	protected String name;
	protected String traitText;
	protected String declineTraitText = "This race has no trait in decline.";
	protected Player activePlayer;
	protected Map map;
	protected int raceIncome;
	protected String image;

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.image = "../../images/races/placeHolder.png";
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

	public String getDeclineTraitText() {
		return declineTraitText;
	}

	public void setDeclineTraitText(String declineTraitText) {
		this.declineTraitText = declineTraitText;
	}

}

