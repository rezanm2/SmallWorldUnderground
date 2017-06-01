package controllers;

import playBoard.Map;

public class MapTester
{
	private int terrainCounter;


	public void whichTokenType(Map map)					//Show all areas which are currently attackable
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			System.out.println(terrainCounter + 1 + " " + map.getTerrain(terrainCounter).getTokenType());	//Return the tokenType
		}
	}



}
