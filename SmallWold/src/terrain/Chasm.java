package terrain;

public class Chasm extends Terrain
{
	public Chasm(int[] arrayId)
	{
		super(arrayId);
		isImmune = true;
	}
}
