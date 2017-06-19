package controllers;

import java.util.List;

import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;


public class TokenController
{

	Player racesPlayer;

	List<Player> playerList;
	private int returnedTokens;
	Map map;

	public TokenController(Ammy ammy)
	{
		this.playerList = ammy.getPlayerCreator().getPlayerList();
		this.map = ammy.getMap();
	}

	public void linkRaceToPlayer(Race race)
	{
		for(int playerCounter = 0;playerCounter<playerList.size();playerCounter++)
		{
			if(playerList.get(playerCounter).getActiveSet().getRace().equals(race))
			{
				System.out.println("A: The race is " + race.getName() + " and it is "
						+ "'s active race.");

				racesPlayer = playerList.get(playerCounter);
			}
			else if(playerList.get(playerCounter).getDeclineSet().getRace().equals(race))
			{
				System.out.println("A: The race is " + race.getName() + " and it is "
						+ "'s decline race.");

				racesPlayer = playerList.get(playerCounter);
			}
		}
	}

	public void calculateReturnedTokens(Player activePlayer)
	{
		returnedTokens = 0;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsRedeployable() == true)						//If isAttackable is true
			{
				this.returnedTokens = returnedTokens + map.getTerrain(terrainCounter).getAmountOfTokens() - 1;
				map.getTerrain(terrainCounter).setToOne();
			}
		}
		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + returnedTokens);

	}

	public void setRacesPlayer(Player racesPlayer)
	{
		this.racesPlayer = racesPlayer;
	}
	public Player getRacesPlayer()
	{
		return racesPlayer;
	}
}