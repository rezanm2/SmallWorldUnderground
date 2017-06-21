package terrain;

public class Chasm extends Terrain
{
	public Chasm(String[] arrayId)
	{
		super(arrayId);
		isImmune = true;
		terrainName = "Chasm";
	}
}
