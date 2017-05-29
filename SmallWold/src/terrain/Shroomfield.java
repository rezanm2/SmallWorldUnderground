package terrain;

public class Shroomfield extends Terrain
{
	boolean isAttackable = false;
	boolean isReinforcable = false;

	public Shroomfield(String idCode, String tokenType, int defense)
	{
		super(idCode, tokenType, defense);
	}

}
