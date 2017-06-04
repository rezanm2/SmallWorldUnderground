package ammy;

import java.util.List;

import controllers.CombatController;
import controllers.EndTurnController;
import controllers.MapTester;
import mapInitializers.Initializer;
import playBoard.Map;
import setup.DeclareCombat;
import setup.MapCreator;
import setup.PickRegions;
import setup.PlayerCreator;
import player.Player;
import terrain.Terrain;

public class Ammy
{
	MapCreator mapCreator;			//Create a new MapCreator
	PlayerCreator playerCreator = new PlayerCreator();	//Create a new PlayerCreator
	CombatController cc;
	MapTester test;
	PickRegions pickRegions;
	DeclareCombat dc;
	Map map;
	EndTurnController etc;
	List<Player> playerList;
	Initializer mapType;

	public void playerSetup()
	{

		System.out.println("Ammy: I'm running! \n");

		playerCreator.defineAmountOfPlayers(); 					//Asks how many players will play the game
		playerCreator.definePlayers();
		System.out.println("Ammy: I'm creating all of your players. \n");
		this.playerList = playerCreator.getPlayerList();
		this.createAccordingMap();
	}

	public void createAccordingMap()
	{
		System.out.println("Ammy: I'm creating the according map for " + playerCreator.getAmountOfPlayers() + " players. \n");

		mapCreator = new MapCreator();									//Creating mapCreator
		mapCreator.setupMap(playerCreator.getAmountOfPlayers());		//MapCreator needs the playerCreator
		this.map = new Map(mapCreator.getTerrainList());								//Map needs terrains.
		System.out.println("Created map.");
		map.allTerrainsToString();

				//mapCreator needs map.


		mapCreator.setupMap(playerCreator.getAmountOfPlayers());
	}

	public void createCreators()
	{
		System.out.println("Ammy: I'm creating all the creators. \n" );
		playerCreator = new PlayerCreator();
		test = new MapTester(map);										//MapTester needs the map.
		cc = new CombatController(map);								//CombatController needs the map.
		pickRegions = new PickRegions(map, playerCreator.getPlayerList());
		dc = new DeclareCombat(map, cc, test, playerCreator);
		etc = new EndTurnController(map);
		System.out.println("A: Done creating creators... \n");

	}

	public void startGame()
	{

	}


	//Getters and Setters

	public MapCreator getMapCreator() {
		return mapCreator;
	}

	public void setMapCreator(MapCreator mapCreator) {
		this.mapCreator = mapCreator;
	}

	public PlayerCreator getPlayerCreator() {
		return playerCreator;
	}

	public void setPlayerCreator(PlayerCreator playerCreator) {
		this.playerCreator = playerCreator;
	}

	public CombatController getCc() {
		return cc;
	}

	public void setCc(CombatController cc) {
		this.cc = cc;
	}

	public MapTester getTest() {
		return test;
	}

	public void setTest(MapTester test) {
		this.test = test;
	}

	public PickRegions getPickRegions() {
		return pickRegions;
	}

	public void setPickRegions(PickRegions pickRegions) {
		this.pickRegions = pickRegions;
	}

	public DeclareCombat getDc() {
		return dc;
	}

	public void setDc(DeclareCombat dc) {
		this.dc = dc;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public EndTurnController getEtc() {
		return etc;
	}

	public void setEtc(EndTurnController etc) {
		this.etc = etc;
	}

	public Initializer getMapType() {
		return mapType;
	}

	public void setMapType(Initializer init) {
		this.mapType = init;
	}
}
