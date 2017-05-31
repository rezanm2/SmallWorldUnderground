package terrain;

import relics.Relic;
import specialPlaces.SpecialPlace;

public abstract class Terrain
{
	protected int[] idArray;
	protected String tokenType;
	protected int amountOfTokens;
	protected int defense;

	protected boolean isAttackable;
	protected boolean isReinforcable;
	protected boolean isImmune;

	protected Relic relic;
	protected SpecialPlace specialPlace;

	public Terrain(int[] idArray)
	{
		this.idArray = idArray;
	}

	public void setSpecificTerrain(int[] idArray)
	{
		this.idArray = idArray;
	}

	public int getSpecificTerrain(int arrayOrder)
	{
		return idArray[arrayOrder];
	}

	public void setIdArray(int[] idArray)
	{
		this.idArray = idArray;
	}

	public int[] getIdArray()
	{
		return idArray;
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

	public void setRelic(Relic relic)
	{
		this.relic = relic;
	}

	public Relic getRelic()
	{
		return relic;
	}

	public void setSpecialPlace(SpecialPlace specialPlace)
	{
		this.specialPlace = specialPlace;
	}

	public SpecialPlace getSpecialPlace()
	{
		return specialPlace;
	}

}
