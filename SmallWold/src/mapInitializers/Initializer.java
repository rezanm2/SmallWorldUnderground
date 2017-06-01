package mapInitializers;

import java.util.ArrayList;
import java.util.List;



import playBoard.Map;
import races.Empty;
import races.Race;
import terrain.Terrain;

public class Initializer
{

	private int terrainCounter;
	protected List<Terrain> terrains = new ArrayList<Terrain>();
	Race empty = new Empty();

	public void setTerrains(List<Terrain> terrains)
	{
		this.terrains = terrains;
	}
	public List<Terrain> getTerrains()
	{
		return terrains;
	}

	public void setEmpty(Map map)
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setRace(empty);
		}
	}
}
