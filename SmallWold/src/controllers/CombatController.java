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

	public void isAttackable(Map map, int code)
	{
		j = 0;
		i = 0;
		terrain = 0;
		value = 0;

		while(j<map.getTerrains().size())
		{
			while(i<map.getTerrain(terrain).getIdArray().length)
			{

				if(map.getTerrain(terrain).getSpecificTerrain(value) == code)
				{
					map.getTerrain(terrain).setIsAttackable(true);
				}

				System.out.println("Value: " + map.getTerrain(terrain).getSpecificTerrain(value));
				System.out.println("Length of array" + map.getTerrain(terrain).getIdArray().length);

				System.out.println("Terrain (counter): " + i);

				value++;
				i++;
			}
			i = 0;
			value = 0;
			j++;
			terrain++;
		}



	}






	public void declareTokenAmount(int declaredAmountOfTokens)
	{
		this.declaredAmountOfTokens = declaredAmountOfTokens;
	}

	public void calculateCombat(Terrain terrain, Player activePlayer, Player passivePlayer)
	{
		if(terrain.getAmountOfTokens() + terrain.getDefense() <= declaredAmountOfTokens + 2)
		{
			terrain.setTokenType(activePlayer.getActiveSet().getRace().getTokenType());
			terrain.setAmountOfTokens(declaredAmountOfTokens);
		}
		else
		{
			//Roll conquest die or attack something different
		}
	}
}
