package controllers;

import playBoard.Map;
import player.Player;
import terrain.Terrain;
import races.Race;

public class CombatController
{
	private int declaredAmountOfTokens;
	private int j;
	private int i;
	private int terrain;
	private int value;
	private int[] trueTerrains;


	public void whichAreAttackable(Map map)
	{
		for(i=0;i<map.getTerrains().size();i++)
		{
		if(map.getTerrain(i).getIsAttackable() == true)
			{
			System.out.println(i + 1 + ": True");
			}
		}
	}

	public void setUnattackable(Map map)
	{
		for(i=0;i<map.getTerrains().size();i++)
		{
		if(map.getTerrain(i).getIsAttackable() == true)
			{
			map.getTerrain(i).setIsAttackable(false);
			}
		}
	}


	public void isAttackable(Map map, int code)
	{
		j = 0;
		i = 0;
		terrain = 0;
		value = 0;

		while(j<map.getTerrains().size())				//While there's still terrains left
		{
			while(i<map.getTerrain(terrain).getIdArray().length)		//While there's still numbers in the terrain's array
			{

				if(map.getTerrain(terrain).getSpecificTerrain(value) == code)		//If the idCode is found, set isAttackable to true
				{
					map.getTerrain(terrain).setIsAttackable(true);
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				i++;												//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			i = 0;													//Back at number 0 in a fresh terrain
			j++;													//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
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
