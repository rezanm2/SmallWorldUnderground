package main;

import java.util.List;

import controllers.CombatController;
import controllers.EndTurnController;
import controllers.MapTester;
import controllers.SleepController;
import controllers.TerrainController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import listCreators.RelicListCreator;
import mapInitializers.Initializer;
import playBoard.Die;
import playBoard.Map;
import setup.DeclareCombat;
import setup.MapCreator;
import setup.PickRegions;
import setup.PlayerCreator;
import setup.RedeployAreas;
import player.Player;
import terrain.Terrain;

public class Ammy
{
	//This entire list is just for references, for the setters and getters of Ammy.
	MapCreator mapCreator;
	CombatController cc;
	MapTester test;
	PickRegions pickRegions;
	DeclareCombat dc;
	Map map;
	EndTurnController etc;
	Player activePlayer;
	List<Player> playerList;
	RedeployAreas ra;
	Initializer mapType;
	TerrainController tc;
	SleepController sleep = new SleepController();
	Die die = new Die();
	Decline decline;
	PlayerCreator playerCreator;
	AbilityListCreator abilityList;
	RaceListCreator raceList;
	RelicListCreator relicList;
	int maxTotalTurns;

	public void playerSetup()		//This method sets up the players, the amount of Players, and their names.
	{

		System.out.println("Ammy: I'm running! \n");
		playerCreator = new PlayerCreator();

		playerCreator.defineAmountOfPlayers(); 					//Asks how many players will play the game
		playerCreator.definePlayers();
		playerCreator.setDefaultSets();
		System.out.println("Ammy: I'm done creating all of your players.");
		this.playerList = playerCreator.getPlayerList();
		activePlayer = playerCreator.getPlayerList().get(0);
		this.createAccordingMap();
	}

	public void createAccordingMap()	//This method sets up the map, the appropriate one for how many players were selected.
	{
		System.out.println("Ammy: I'm creating the according map for " + playerCreator.getAmountOfPlayers() + " players. \n");
		mapCreator = new MapCreator();
		mapCreator.setupMap(this);
		this.map = new Map(this);
		System.out.println("Created map.");
		mapCreator.setupMap(this);
		System.out.println("Ammy: I'm done creating the according map.");
	}



	public void createCreators()		//This method creates all the creators, for future reference.
	{
		System.out.println("Ammy: I'm creating all the creators. \n" );
		tc = new TerrainController(this);
		test = new MapTester(this);
		cc = new CombatController(this);
		pickRegions = new PickRegions(this);
		dc = new DeclareCombat(this);
		etc = new EndTurnController(this);
		ra = new RedeployAreas(this);
		decline = new Decline(this);
		System.out.println("Ammy: Done creating creators... \n");
		System.out.println("A: I'm starting your game... \n");
	}

	public void createLists()
	{
		abilityList = new AbilityListCreator();
		raceList = new RaceListCreator();
		relicList = new RelicListCreator();
	}

	public void setEverythingOnAmmy()
	{
		this.playerList = playerCreator.getPlayerList();
	}

	public void startGame()
	{
		this.activePlayer = playerList.get(0);
		System.out.println("A: It is now " + activePlayer.getName() + "'s turn.");
		pickRegions.start();

		for(int totalTurnCounter=0;totalTurnCounter<mapCreator.getMaxTotalTurns();totalTurnCounter++)
		{
			for(int playerTurnCounter=0;playerTurnCounter<playerList.size();playerTurnCounter++)
			{
				activePlayer = playerList.get(playerTurnCounter);
				dc.start(activePlayer);
				ra.start(this);
				etc.start(activePlayer);
		//		decline.shuffleSets();
		//		decline.chooseNewSet();
		//		decline.goInDecline();
			}
		}
	}

	//Getters and Setters below this line ---------------------------------------------------

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

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public SleepController getSleep() {
		return sleep;
	}

	public void setSleep(SleepController sleep) {
		this.sleep = sleep;
	}

	public AbilityListCreator getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(AbilityListCreator abilityList) {
		this.abilityList = abilityList;
	}

	public RaceListCreator getRaceList() {
		return raceList;
	}

	public void setRaceList(RaceListCreator raceList) {
		this.raceList = raceList;
	}

	public RelicListCreator getRelicList() {
		return relicList;
	}

	public void setRelicList(RelicListCreator relicList) {
		this.relicList = relicList;
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

	public Die getDie() {
		return die;
	}

	public void setDie(Die die) {
		this.die = die;
	}
	public RedeployAreas getRa() {
		return ra;
	}

	public void setRa(RedeployAreas ra) {
		this.ra = ra;
	}

	public TerrainController getTc() {
		return tc;
	}

	public void setTc(TerrainController tc) {
		this.tc = tc;
	}
}
