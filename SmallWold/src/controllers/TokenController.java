package controllers;

import java.util.List;

import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;
/**
 * Deze klasse is verantwoordelijk voor het regelen van alle tokens.
 * @author Jeroen Zandvliet
 *
 */

public class TokenController
{

	Player racesPlayer;

	List<Player> playerList;
	private int returnedTokens;
	private int declineTokens;
	Map map;

	public TokenController(Ammy ammy)
	{
		this.map = ammy.getMap();
	}

	/**
	 * Checked welke speler bij het meegegeven ras hoort.
	 * @param race, het ras waarop gechecked wordt.
	 */
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

	/**
	 * Berekend hoeveel tokens de speler terugkrijgt.
	 * @param activePlayer, de actieve speler.
	 */
	public void calculateReturnedTokens(Player activePlayer)
	{
		returnedTokens = 0;
		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsRedeployable() == true)						//If isAttackable is true
			{
				this.returnedTokens = returnedTokens + map.getTerrains().get(terrainCounter).getAmountOfTokens() - 1;
				map.getTerrains().get(terrainCounter).setToOne();
			}
		}
		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + returnedTokens);

	}

	/**
	 * Check hoeveel tokens de speler in decline heeft.
	 * @param activePlayer
	 */
	public void checkAmountOfDeclineTokens(Player activePlayer)
	{
		activePlayer.getHand().setDeclineTokens(0);
		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getRace().getName().equals(activePlayer.getDeclineSet().getRace().getName()))
			{
				activePlayer.getHand().setDeclineTokens(activePlayer.getHand().getDeclineTokens()
						+ map.getTerrains().get(terrainCounter).getAmountOfTokens());
			}
		}
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