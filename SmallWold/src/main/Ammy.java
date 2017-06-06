package main;

import java.util.List;

import controllers.CombatController;
import controllers.EndTurnController;
import controllers.MapTester;
import controllers.SleepController;
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
import setup.ReinforceAreas;
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
	Player activePlayer;
	List<Player> playerList;
	ReinforceAreas ra;
	Initializer mapType;
	SleepController sleep = new SleepController();
	AbilityListCreator abilityList = new AbilityListCreator();
	RaceListCreator raceList = new RaceListCreator();
	RelicListCreator relicList = new RelicListCreator();
	Die die = new Die();

	public void playerSetup()
	{

		System.out.println("Ammy: I'm running! \n");
		playerCreator.defineAmountOfPlayers(); 					//Asks how many players will play the game
		playerCreator.definePlayers();
		playerCreator.setDefaultSets();
		System.out.println("Ammy: I'm done creating all of your players.");
		this.playerList = playerCreator.getPlayerList();
		activePlayer = playerCreator.getPlayerList().get(0);
		this.createAccordingMap();
	}

	public void createAccordingMap()
	{
		System.out.println("Ammy: I'm creating the according map for " + playerCreator.getAmountOfPlayers() + " players. \n");
		mapCreator = new MapCreator();
		mapCreator.setupMap(this);
		this.map = new Map(this);
		System.out.println("Created map.");
		mapCreator.setupMap(this);
		System.out.println("Ammy: I'm done creating the according map.");
	}



	public void createCreators()
	{
		System.out.println("Ammy: I'm creating all the creators. \n" );
		test = new MapTester(this);									//MapTester needs the map.
		cc = new CombatController(this);							//CombatController needs the map.
		pickRegions = new PickRegions(this);						//
		dc = new DeclareCombat(this);
		etc = new EndTurnController(this);
		this.ra = new ReinforceAreas(this);
		System.out.println("Ammy: Done creating creators... \n");
	}

	public void setEverythingOnAmmy()
	{
		this.playerList = playerCreator.getPlayerList();
	}

	public void startGame()
	{
		System.out.println("A: I'm starting your game... \n");
		activePlayer = playerList.get(0);
		pickRegions.start();
		etc.getAllAbilityIncome();
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

}
