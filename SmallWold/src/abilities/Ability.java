package abilities;

import main.Ammy;
import player.Player;

public abstract class Ability
{
	protected int amountOfTokens;
	protected int abilityIncome;
	protected String name;
	protected String traitText;
	protected boolean active;
	protected Player activePlayer;
	protected String image;
	protected String declineTraitText = "This ability has no trait in decline.";

	public Ability()
	{
		image = "../../images/abilitys/placeHolder.png";
	}

	public String getDeclineTraitText() {
		return declineTraitText;
	}

	public void setDeclineTraitText(String declineTraitText) {
		this.declineTraitText = declineTraitText;
	}

	public abstract void processAbility(Ammy ammy);

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

	public void processAbility(Ammy ammy, int replaceAmount) {
		// TODO Auto-generated method stub

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
