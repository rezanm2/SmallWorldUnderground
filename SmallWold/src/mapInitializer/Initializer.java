package mapInitializer;

import java.util.ArrayList;
import java.util.List;

import terrain.Terrain;

public class Initializer
{

	List<Terrain> terrains = new ArrayList<Terrain>();

	public void setTerrains(List<Terrain> terrains)
	{
		this.terrains = terrains;
	}
	public List<Terrain> getTerrains()
	{
		return terrains;
	}
}
