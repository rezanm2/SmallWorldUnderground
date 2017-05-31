package terrain;

public class Chasm extends Terrain
{
	public Chasm(String ownId, String otherId)
	{
		super(ownId, otherId);
		isImmune = true;
	}
}
