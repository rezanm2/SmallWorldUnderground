package controllers;

import playBoard.Map;
import player.Player;
import terrain.Terrain;
import races.Race;

public class CombatController
{
	private int declaredAmountOfTokens;
	private int terrainCounter;
	private int elementCounter;
	private int terrain;
	private int value;


	public void whichAreAttackable(Map map)					//Show all areas which are currently attackable
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
		if(map.getTerrain(terrainCounter).getIsAttackable() == true)		//If isAttackable is true
			{
			System.out.println(terrainCounter + 1 + ": True");			//Print the number of the iteration and whether it's true or false
			}
		}
	}

	public void setUnattackable(Map map)					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
		if(map.getTerrain(terrainCounter).getIsAttackable() == true)		//If isAttackable is true
			{
			map.getTerrain(terrainCounter).setIsAttackable(false);		//Set it to false
			}
		}
	}


	public void isAttackable(Map map, int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)		//While there's still numbers in the terrain's array
			{

				if(map.getTerrain(terrain).getElement(value) == code)		//If the idCode is found, set isAttackable to true
				{
					map.getTerrain(terrain).setIsAttackable(true);
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				elementCounter++;									//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			elementCounter = 0;										//Back at number 0 in a fresh terrain
			terrainCounter++;										//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
		whichAreAttackable(map);
	}

	public void declareTokenAmount(int declaredAmountOfTokens)				//Player declaring amount of tokens for attack
	{
		this.declaredAmountOfTokens = declaredAmountOfTokens;
	}

	public void calculateCombat(Terrain terrain, Player activePlayer, Player passivePlayer)		//Calculating win or lose
	{
		if(terrain.getAmountOfTokens() + terrain.getDefense() <= declaredAmountOfTokens + 2)	//If the player wins
		{
			terrain.setTokenType(activePlayer.getActiveSet().getRace().getTokenType());	  //Make the terrain be the player's tokenType
			terrain.setAmountOfTokens(declaredAmountOfTokens);							  //The declared amount is set on the terrain
		}
		else																					//If the player loses
		{
			//Roll conquest die or attack something different
		}
	}
}
