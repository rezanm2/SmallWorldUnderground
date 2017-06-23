package playBoard;

import java.util.ArrayList;
import java.util.List;
import listCreators.RaceListCreator;
import listCreators.RelicListCreator;
import listCreators.SpecialPlaceListCreator;
import main.Ammy;
import races.Empty;
import races.Race;
import terrain.Terrain;

public class Map_old
{

	List<Terrain> terrains = new ArrayList<Terrain>();
	RaceListCreator raceList;
	RelicListCreator relicList;
	SpecialPlaceListCreator specialPlaceList;
	Die die = new Die();
	private int terrainCounter;


	public void Map(Ammy ammy)
	{
		this.terrains = ammy.getMapCreator().getTerrainList();
		this.relicList = ammy.getRelicList();
		this.specialPlaceList = ammy.getSpecialPlaceList();
		this.raceList = ammy.getRaceList();
		this.setEmpty();
	}

	public void setEmpty()
	{
		for(terrainCounter=0;terrainCounter<getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			getTerrain(terrainCounter).setRace(raceList.getListElement(0));
			getTerrain(terrainCounter).setRelic(relicList.getListElement(0));
			getTerrain(terrainCounter).setSpecialPlace(specialPlaceList.getListElement(0));
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
					+ "\t    " + getTerrain(terrainCounter).getRace().getName() + "\t \t"
					+ getTerrain(terrainCounter).getAmountOfTokens() + "\t  ");

			for(int element=0; (element+1 )<getTerrain(terrainCounter).getIdArray().length; element++)
			{
				System.out.print(" " + getTerrain(terrainCounter).getElement(element+1));
			}
			System.out.println();
		}
	System.out.println();
	}

	public void setTerrain(Terrain terrain, int pos) {
		terrains.set(pos, terrain);
	}
}
