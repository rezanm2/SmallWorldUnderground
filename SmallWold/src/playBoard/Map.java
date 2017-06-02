package playBoard;

import java.util.ArrayList;
import java.util.List;

import controllers.SleepController;
import mapInitializers.FourPlayer;
import races.Empty;
import races.Race;
import terrain.Terrain;

public class Map
{

	List<Terrain> terrains = new ArrayList<Terrain>();
	Die die = new Die();
	private int terrainCounter;
	Race empty = new Empty();
	SleepController sleep = new SleepController();


	public Map(List<Terrain> terrains)
	{
		this.terrains = terrains;
		this.setEmpty();
	}

	public void setEmpty()
	{
		for(terrainCounter=0;terrainCounter<getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			getTerrain(terrainCounter).setRace(empty);
		}
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

	public void allTerrainsToString()
	{
		System.out.println("A: Giving you a list of all the terrains on this map...");
		System.out.println("Terrain:  Type : Occupied by : Amount of tokens");
		for(int terrainCounter=0;terrainCounter<getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			System.out.println("  " + (terrainCounter + 1) + "	" + getTerrain(terrainCounter).getTerrainName()
					+ "	    " + getTerrain(terrainCounter).getRace().getTokenType() + "	  "
					+ getTerrain(terrainCounter).getRace().getAmountOfTokens());
		}
	}
}
