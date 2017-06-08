package mapInitializers;

import java.util.ArrayList;
import java.util.List;



import playBoard.Map;
import races.Empty;
import races.Race;
import terrain.Terrain;

public class Initializer
{
	protected int maxTotalTurns;
	protected List<Terrain> terrains = new ArrayList<Terrain>();

	public void setTerrains(List<Terrain> terrains)
	{
		this.terrains = terrains;
	}
	public List<Terrain> getTerrains()
	{
		return terrains;
	}

	public void initialize()
	{
		System.out.println("A: Filling map with terrains...");
	}

	public void setMaxTotalTurns(int maxTotalTurns)
	{
		this.maxTotalTurns = maxTotalTurns;
	}
	public int getMaxTotalTurns()
	{
		return maxTotalTurns;
	}
}
