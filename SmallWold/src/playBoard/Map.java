package playBoard;

import java.util.ArrayList;
import java.util.List;

import mapInitializer.MapInitializer;
import terrain.Terrain;

public class Map
{
	MapInitializer init = new MapInitializer();

	List<Terrain> terrains = new ArrayList<Terrain>();
	Die die = new Die();


	public Map(List<Terrain> terrains, Die die)
	{
		this.terrains = terrains;
		this.die = die;
	}

	public Terrain getTerrain(int x)
	{
		return terrains.get(x);
	}

	public List<Terrain> getTerrains()
	{
		return terrains;
	}

}
