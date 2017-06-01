package controllers;

import playBoard.Map;

public class MapTester
{
	private int terrainCounter;
	Map map = new Map();
	private int code;

	public MapTester(Map map)
	{
		this.map = map;
	}


	public void whatsOnTerrain()					//Show all areas which are currently attackable
	{
		System.out.println("Terrain : TokenType: : Amount");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			System.out.println(terrainCounter + 1 + "	    " + map.getTerrain(terrainCounter).getRace().getTokenType() +
					"	 " + map.getTerrain(terrainCounter).getRace().getAmountOfTokens());	//Return the tokenType
		}
	}

	public void whichAreAttackable(int code)					//Show all areas which are currently attackable
	{
		System.out.println("Terrain : isAttackable  : Containing");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
		if(map.getTerrain(terrainCounter).getIsAttackable() == true)		//If isAttackable is true
			{
			System.out.println(terrainCounter + 1 + "		True		" + code);			//Print the number of the iteration and whether it's true or false
			}
		}
	}

}
