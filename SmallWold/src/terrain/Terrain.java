package terrain;

import relics.Relic;
import specialPlaces.SpecialPlace;

public abstract class Terrain
{
	protected String idCode;
	protected String tokenType;
	protected int amountOfTokens;
	protected int defense;

	protected boolean isAttackable;
	protected boolean isReinforcable;


	protected Relic hasRelic = null;
	protected SpecialPlace hasSpecialPlace = null;

	public Terrain(String idCode, String tokenType, int defense)
	{
		this.idCode = idCode;
		this.tokenType = tokenType;
		this.defense = defense;
	}

	public void setIdCode(String idCode)
	{
		this.idCode = idCode;
	}


	public String getIdCode()
	{
		return idCode;
	}


	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}


	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}


	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public void setIsAttackable(boolean isAttackable) {
		this.isAttackable = isAttackable;
	}

	public boolean getIsAttackable() {
		return isAttackable;
	}

	public void setIsReinforcable(boolean isReinforcable) {
		this.isReinforcable = isReinforcable;
	}

	public boolean getIsReinforcable() {
		return isReinforcable;
	}

	public void setToOne() {
		this.setAmountOfTokens(1);
	}

	public void redeploy() {
		}


	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;

	}

	public String getTokenType() {
		return tokenType;
	}




}
