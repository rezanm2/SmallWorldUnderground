package setup;

import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController;
import controllers.MapTester;
import main.Ammy;
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
import terrain.Terrain;

public class MapCreator
{
	private int amountOfPlayers;
	Map map;
	Ammy ammy;
	Initializer mapType;

	List<Terrain> terrainList = new ArrayList<Terrain>();
	List<Player> playerList = new ArrayList<Player>();


	public void setupMap(Ammy ammy)
	{
		amountOfPlayers = ammy.getPlayerList().size();
		System.out.println("Creating " + amountOfPlayers + " players..`.1`.`..1");
		if(amountOfPlayers == 2)
		{
			TwoPlayer mapType = new TwoPlayer();
			mapType.initialize();
			this.terrainList = mapType.getTerrains();
		}
		else if(amountOfPlayers == 3)
		{
			ThreePlayer mapType = new ThreePlayer();
			mapType.initialize();
			this.terrainList = mapType.getTerrains();
		}
		else if(amountOfPlayers == 4)
		{
			FourPlayer mapType = new FourPlayer();
			mapType.initialize();
			this.terrainList = mapType.getTerrains();
		}
		else if(amountOfPlayers == 5)
		{
			FivePlayer mapType = new FivePlayer();
			mapType.initialize();
			this.terrainList = mapType.getTerrains();
		}

	}


	public List<Terrain> getTerrainList() {
		return terrainList;
	}


	public void setTerrainList(List<Terrain> terrainList) {
		this.terrainList = terrainList;
	}


	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public Initializer getMapType() {
		return mapType;
	}

	public void setInit(Initializer mapType) {
		this.mapType = mapType;
	}

	public void setMap(Map map)
	{
		this.map = map;
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
