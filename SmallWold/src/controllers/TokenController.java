package controllers;

import java.util.List;

import main.Ammy;
import player.Player;
import races.Race;


public class TokenController
{

	List<Player> playerList;
	public TokenController(Ammy ammy)
	{
		this.playerList = ammy.getPlayerCreator().getPlayerList();
	}

	public void linkRaceToPlayer(Race race)
	{
		for(int playerCounter = 0;playerCounter<playerList.size();playerCounter++)
		{
			if(playerList.get(playerCounter).getActiveSet().getRace().equals(race))
			{
				System.out.println("A: The race is " + race.getName() + " and it is "
						+ playerList.get(playerCounter).getName() + "'s active race.");
			}
//			else if(playerList.get(playerCounter).getDeclineSet().getRace().equals(race))
//			{
//				System.out.println("A: The race is " + race.getName() + " and it is "
//						+ playerList.get(playerCounter).getName() + "'s decline race.");
//			}
		}




	}
}
