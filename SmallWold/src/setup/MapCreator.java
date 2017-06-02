package setup;

import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController;
import controllers.MapTester;
import main.Set;
import mapInitializers.FivePlayer;
import mapInitializers.FourPlayer;
import mapInitializers.Initializer;
import mapInitializers.ThreePlayer;
import mapInitializers.TwoPlayer;
import playBoard.Die;
import playBoard.Map;
import player.Hand;
import player.Player;
import races.Drow;
import races.Flames;
import races.Race;

public class MapCreator
{
	private int amountOfPlayers;

	Map map = new Map();

	List<Player> playerList = new ArrayList<Player>();

	public void setupMap(int amountOfPlayers)
	{
		if(amountOfPlayers == 2)
		{
			TwoPlayer init = new TwoPlayer();
			init.initialize();
			map.setAllTerrains(init.getTerrains());
		}
		else if(amountOfPlayers == 3)
		{
			ThreePlayer init = new ThreePlayer();
			init.initialize();
			map.setAllTerrains(init.getTerrains());
		}
		else if(amountOfPlayers == 4)
		{
			FourPlayer init = new FourPlayer();
			init.initialize();
			map.setAllTerrains(init.getTerrains());
		}
		else if(amountOfPlayers == 5)
		{
			FivePlayer init = new FivePlayer();
			init.initialize();
			map.setAllTerrains(init.getTerrains());
		}

	}

	public Map getMap()
	{
		return map;
	}

	public int getAmountOfPlayers()
	{
		return amountOfPlayers;
	}

	public void setAmountOfPlayers(int amountOfPlayers)
	{
		this.amountOfPlayers = amountOfPlayers;
	}
}
