package terrain;

public class Stone extends Terrain
{
	public Stone(String ownId, String otherId)
	{
		super(ownId, otherId);
		defense = 1;
	}
}
