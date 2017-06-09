package controllers;

import main.Ammy;
import playBoard.Map;

public class SpecialController
{
	Map map;

	public SpecialController(Ammy ammy)
	{
		this.map = ammy.getMap();
	}
	public void checkCaseHank()
	{
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{

		}
	}

}
