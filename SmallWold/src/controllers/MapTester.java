package controllers;

import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class MapTester
{
	private int terrainCounter;

	Map map;
	Player activePlayer;

	public MapTester(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.activePlayer = ammy.getPlayerList().get(0);
	}


	public void whatsOnTerrain()					//Show all areas which are currently attackable
	{
		System.out.println("Number : Terrain : TokenType: : Amount");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			System.out.println((terrainCounter + 1) + "\t" + map.getTerrain(terrainCounter).getTerrainName()
								+ map.getTerrain(terrainCounter).getRace().getTokenType() +
								"\t" + map.getTerrain(terrainCounter).getRace().getAmountOfTokens());		//Return the tokenType
		}
	}

	public void whichAreAdjacent()					//Show all areas which are currently attackable
	{


		System.out.println("A: Showing which areas are adjacent for " + activePlayer.getName() + "\n");
		System.out.println("A: Number : Terrain : Tokentype : Amount of Tokens");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == true)						//If isAttackable is true
			{
				System.out.println("A: " + (terrainCounter + 1) + "\t     "
						+ map.getTerrain(terrainCounter).getTerrainName() + "\t"
						+ map.getTerrain(terrainCounter).getRace().getTokenType()
						+ "\t" + map.getTerrain(terrainCounter).getAmountOfTokens());
			}
		}
	}

	public void whichAreAttackable()					//Show all areas which are currently attackable
	{
		System.out.println("A: Showing which areas are attackable for " + activePlayer.getName() + "\n");
		System.out.println("A: Number : Terrain : Tokentype : Amount of Tokens");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsAttackable() == true)						//If isAttackable is true
			{
				System.out.println("A: " + (terrainCounter + 1) + "\t     "
						+ map.getTerrain(terrainCounter).getTerrainName() + "\t"
						+ map.getTerrain(terrainCounter).getRace().getTokenType()			//Print the number of the iteration
						+ "\t" + map.getTerrain(terrainCounter).getAmountOfTokens());	//and whether it's true or false
			}
		}
	}

	public void whichAreReinforcable()					//Show all areas which are currently attackable
	{
		System.out.println("A: Showing which areas are reinforcable for " + activePlayer.getName() + "\n");
		System.out.println("A: Number : Terrain : Tokentype : Amount of Tokens");
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsReinforcable() == true)						//If isAttackable is true
			{
			System.out.println("A: " + (terrainCounter + 1) + "\t     "
								+ map.getTerrain(terrainCounter).getTerrainName() + "\t"
								+ map.getTerrain(terrainCounter).getRace().getTokenType()			//Print the number of the iteration
								+ "\t" + map.getTerrain(terrainCounter).getAmountOfTokens());	//and whether it's true or false
			}
		}
	}

}
