package playBoard;

import java.util.ArrayList;
import java.util.List;

import mapInitializers.FourPlayer;
import terrain.Terrain;

public class Map
{

	List<Terrain> terrains = new ArrayList<Terrain>();
	Die die = new Die();

	public Map(List<Terrain> terrains, Die die)
	{
		this.terrains = terrains;
		this.die = die;
	}

	public Map(){}

	public Terrain getTerrain(int x)
	{
		return terrains.get(x);
	}

	public void setAllTerrains(List<Terrain> terrains)
	{
		this.terrains = terrains;
	}

	public List<Terrain> getAllTerrains()
	{
		return terrains;
	}

}
