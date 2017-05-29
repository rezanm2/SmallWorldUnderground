package terrain;

interface Terrain
{


	/*Relic hasRelic = null;
	SpecialPlace hasSpecialPlace = null;*/

	void setIdCode(String idCode);
	String getIdCode();

	void setTokenType(String tokenType);
	String getTokenType();

	void setAmountOfTokens(int amountOfTokens);
	int getAmountOfTokens();

	void setDefense(int defense);
	int getDefense();

	void setIsAttackable(boolean isAttackable);
	boolean getIsAttackable();

	void setIsReinforcable(boolean isReinforcable);
	boolean getIsReinforcable();

	void setToOne();
	void redeploy();


}
