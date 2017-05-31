package controllers;

import player.Player;
import terrain.Terrain;
import races.Race;

public class CombatController
{
	private int declaredAmountOfTokens;

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
