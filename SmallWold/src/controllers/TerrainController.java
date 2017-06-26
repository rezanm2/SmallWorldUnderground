package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import playBoard.Map;
import player.Player;
import races.Race;
import terrain.Terrain;
/**
 * Deze klasse is verantwoordelijk voor het regelen van de terreinstatussen.
 * @author Jeroen Zandvliet
 */
public class TerrainController
{
	private int terrainCounter;
	private Player activePlayer;
	private Map map;
	private int elementCounter = 0;
	private int terrain = 0;
	private int typeTerrainCounter;
	private int value = 0;
	private int areaPicked;
	private int returnedTokens;
	private int terrainStringCounter;
	private ArrayList<Integer> Terrainslist = new ArrayList<Integer>();
	Scanner input = new Scanner(System.in);

	public TerrainController(Map map)
	{
		this.map = map;
	}


	/**
	 * Zet alle terreinen op aangrenzend.
	 * @param race, het ras waarmee vergeleken moet worden..
	 */
	public void allAdjacentAreas(Race race)
	{
		for(int terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)	//For every terrain
		{
			if(map.getTerrains().get(terrainCounter).getRace() == null)
			{
			}
			else
			{
				if(map.getTerrains().get(terrainCounter).getRace().equals(race))					//If it's the player's
				{
					for(int secondTerrainCounter = 0; secondTerrainCounter<map.getTerrains().size(); secondTerrainCounter++) //Search through all terrains
					{

						for(int elementCounter = 0; elementCounter<map.getTerrains().get(secondTerrainCounter).getIdArray().length; elementCounter++) //For the player's terrain's code
						{


							if(map.getTerrains().get(secondTerrainCounter).getElement(elementCounter).equals(map.getTerrains().get(terrainCounter).getElement(0)))
							{
								map.getTerrains().get(secondTerrainCounter).setIsAdjacent(true);	//And if found, set the area to adjacent.

							}
						}
					}
				}
			}
		}
	}


	/**
	 * Zet all terreinen op aanvalbaar.
	 * @param activePlayer, de speler waarvan de terreinen aanvalbaar gezet moeten worden.
	 */
	public void allAttackableAreas(Race race)
	{


		for(int terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)
		{
			for(int elementCounter = 0; elementCounter<map.getTerrains().get(terrainCounter).getIdArray().length; elementCounter++)
			{
				if(map.getTerrains().get(terrainCounter).getRace() == null || !map.getTerrains().get(terrainCounter).getRace().equals(race))
				{
					if(map.getTerrains().get(terrainCounter).getIsAdjacent() == true)
					{
						map.getTerrains().get(terrainCounter).setIsAttackable(true);
					}
				}
			}
		}
	}

	/**
	 * Zet all terreinen op heraanvulbaar.
	 * @param activePlayer, de speler wiens terreinen op heraanvulbaar gezet moeten worden.
	 */
	public void allRedeployableAreas(Race race)
	{
		for(int terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)
		{
			if(map.getTerrains().get(terrainCounter).getRace() == null || map.getTerrains().get(terrainCounter).getRace().equals(race))
			{
				map.getTerrains().get(terrainCounter).setIsRedeployable(true);
			}
		}
	}
	/**
	 * Zet alle terreinen op niet aangrenzend
	 */

	public void setNotAdjacent()
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsAdjacent(false);		//Set it to false
		}
	}

	/**
	 * Zet alle terreinen op niet aanvalbaar.
	 */
	public void setNotAttackable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsAttackable(false);		//Set it to false
		}
	}
	/**
	 * Zet alle terreinen op niet heraanvulbaar.
	 */
	public void setNotRedeployable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsRedeployable(false);		//Set it to false
		}
	}

	/**
	 * Checked of een terrein aangrenzend is aan het meegegeven type terrein.
	 * @param terrainString, het type terrein.
	 */
	public void checkAdjacentToTerrainType(String terrainString)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)
		{
			if(map.getTerrains().get(typeTerrainCounter).getTerrainName().equals(terrainString))
			{
//				changeAllAdjacentAreas(map.getTerrains().get(typeTerrainCounter).getElement(0));


			}
		}
		excludeAdjacent(terrainString);
	}

	/**
	 * Checked welke terreinen aangrenzen zijn aan 1 terrein
	 * @param terrain, het terrein.
	 */
	public void checkAdjacentToSingleTerrain(Terrain terrain)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)	//As long as there's terrains
		{
//			changeAllAdjacentAreas(terrain.getElement(0));
		}
	}

	/**
	 * Verwijdert het eigen terrein van "adjacent".
	 * @param terrainType, het type dat meegegeven wordt.
	 */
	public void excludeAdjacent(String terrainType)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)
		{
			if(map.getTerrains().get(typeTerrainCounter).getIsAdjacent() == true && map.getTerrains().get(typeTerrainCounter).getTerrainName() == terrainType)
			{
				map.getTerrains().get(typeTerrainCounter).setIsAdjacent(false);
			}
		}
	}



	/**
	 * Berekend op hoeveel terreinen van het meegegeven type de meegegeven speler zit.
	 * @param terrainString, het type terrein.
	 * @param activePlayer, de speler.
	 */
	public void checkTerrainType(String terrainString, Race race)
	{

		for(int terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)
		{
			if(map.getTerrains().get(terrain).getTerrainName().equals(terrainString) && map.getTerrains().get(terrain).getRace().equals(race))
			{
				terrainStringCounter++;
			}
		}
	}


	public int getReturnedTokens() {
		return returnedTokens;
	}

	public void setReturnedTokens(int returnedTokens) {
		this.returnedTokens = returnedTokens;
	}

	public int getAreaPicked() {
		return areaPicked;
	}

	public void setAreaPicked(int areaPicked) {
		this.areaPicked = areaPicked;
	}

	public int getTerrainStringCounter()
	{
		return terrainStringCounter;
	}
	public void setTerrainStringCounter(int terrainStringCounter)
	{
		this.terrainStringCounter = terrainStringCounter;
	}

	public ArrayList<Integer> getTerrainslist() {
		return Terrainslist;
	}

	public void setTerrainslist(ArrayList<Integer> terrainslist) {
		Terrainslist = terrainslist;
	}


}
