package playBoard;

import java.util.ArrayList;
import java.util.List;

import controllers.SleepController;
import main.Ammy;
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
		System.out.println("Terrain:  Type : Occupied by : Amount of tokens : Adjacent to");
		for(int terrainCounter=0;terrainCounter<getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			System.out.print("  " + (terrainCounter + 1) + "\t " + getTerrain(terrainCounter).getTerrainName()
					+ "\t    " + getTerrain(terrainCounter).getRace().getTokenType() + "\t \t"
					+ getTerrain(terrainCounter).getAmountOfTokens() + "\t  ");

			for(int element=0; (element+1 )<getTerrain(terrainCounter).getIdArray().length; element++)
			{
				System.out.print(" " + getTerrain(terrainCounter).getElement(element+1));
			}
			System.out.println();
		}
	System.out.println();
	}
}
