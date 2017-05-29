package terrain;

public class Shroomfield implements Terrain
{
	String idCode = "AA, BB, CC";
	String tokenType = "Cultists";
	int amountOfTokens = 0;
	int defense = 0;

	boolean isAttackable = false;
	boolean isReinforcable = false;

	public Shroomfield(String idCode, String tokenType, int defense)
	{
		this.idCode = idCode;
		this.tokenType = tokenType;
		this.defense = defense;
	}

	@Override
	public void setIdCode(String idCode)
	{
		this.idCode = idCode;
	}

	@Override
	public String getIdCode() {
		return idCode;
	}

	@Override
	public void setAmountOfTokens(int amountOfTokens) {
		this.amountOfTokens = amountOfTokens;

	}

	@Override
	public int getAmountOfTokens() {
		return amountOfTokens;
	}

	@Override
	public void setDefense(int defense) {
		this.defense = defense;

	}

	@Override
	public int getDefense() {
		return defense;
	}

	@Override
	public void setIsAttackable(boolean isAttackable) {
		this.isAttackable = isAttackable;
	}

	@Override
	public boolean getIsAttackable() {
		return isAttackable;
	}

	@Override
	public void setIsReinforcable(boolean isReinforcable) {
		this.isReinforcable = isReinforcable;
	}

	@Override
	public boolean getIsReinforcable() {
		return isReinforcable;
	}

	@Override
	public void setToOne() {
		this.setAmountOfTokens(1);
	}

	@Override
	public void redeploy() {
		}

	@Override
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;

	}
	@Override
	public String getTokenType() {
		return tokenType;
	}

}
