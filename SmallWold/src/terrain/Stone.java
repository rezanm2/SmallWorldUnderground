package terrain;

public class Stone extends Terrain
{
	public Stone(String[] arrayId)
	{
		super(arrayId);
		defense = 1;
		terrainName = "Stone";
	}
}
