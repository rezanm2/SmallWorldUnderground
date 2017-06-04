package controllers;

import ammy.Ammy;
import playBoard.Map;
import terrain.Terrain;

public class MapTester
{
	private int terrainCounter;
	private int code;
	Map map;


	public MapTester(Map map)
	{
		this.map = map;
	}


	public void whatsOnTerrain()					//Show all areas which are currently attackable
	{
		System.out.println("Terrain : TokenType: : Amount");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			System.out.println((terrainCounter + 1) + "	    " + map.getTerrain(terrainCounter).getRace().getTokenType() +
					"	 " + map.getTerrain(terrainCounter).getRace().getAmountOfTokens());		//Return the tokenType
		}
	}

	public void whichAreAdjacent()					//Show all areas which are currently attackable
	{
		System.out.println("A: Terrain : tokenType : amountOfTokens");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
		if(map.getTerrain(terrainCounter).getIsAdjacent() == true)						//If isAttackable is true
			{
			System.out.println("A: " + (terrainCounter + 1) + "\t   "
								+ map.getTerrain(terrainCounter).getRace().getTokenType()			//Print the number of the iteration
								+ "	\t" + map.getTerrain(terrainCounter).getAmountOfTokens());	//and whether it's true or false
			}
		}
	}
}
