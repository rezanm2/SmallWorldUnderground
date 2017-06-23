package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import controllers.CombatController_old;
import controllers.EndTurnController;
import controllers.TerrainController;
import controllers.TokenController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import listCreators.RelicListCreator;
import listCreators.SpecialPlaceListCreator;
import playBoard.Die;
import playBoard.Map;
import setup.DeclareCombat;
import setup.Decline;
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
	CombatController_old cc;
	PickRegions pickRegions;
	DeclareCombat dc;
	Map map;
	EndTurnController etc;
	Player activePlayer;
	List<Player> playerList;
	RedeployAreas ra;
	TerrainController tc;
	Die die = new Die();
	Decline decline;
	PlayerCreator playerCreator;
	AbilityListCreator abilityList;
	RaceListCreator raceList;
	RelicListCreator relicList;
	SpecialPlaceListCreator specialPlaceList;
	Scanner input = new Scanner(System.in);
	Set emptySet;
	private int largest;
	private int choice;
	int maxTotalTurns;
	TokenController toc;

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
		System.out.println("Created map.");
		mapCreator.setupMap(this);
		System.out.println("Ammy: I'm done creating the according map.");
	}



	public void createCreators()		//This method creates all the creators, for future reference.
	{
		System.out.println("Ammy: I'm creating all the creators. \n" );
		tc = new TerrainController(this);

		toc = new TokenController(this);
		cc = new CombatController_old(this);
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
		specialPlaceList = new SpecialPlaceListCreator();


		emptySet = new Set(abilityList.getListElement(0), raceList.getListElement(0));
	}

	public void setEverythingOnAmmy()
	{
		this.playerList = playerCreator.getPlayerList();
	}

	public void startGame(Player player)
	{

	}

	public void declareWinner()
	{
		System.out.println("Ammy: Your game has ended!");

		System.out.println(" has earned " + playerList.get(0).getCoins() + " coins.");
		System.out.println(" has earned " + playerList.get(1).getCoins() + " coins.");

		if(playerList.size() == 2)
		{
			largest = Collections.max(Arrays.asList(playerList.get(0).getCoins(), playerList.get(1).getCoins()));
			System.out.println(" has earned " + playerList.get(2).getCoins() + " coins.");
		}
		if(playerList.size() == 3)
		{
			largest = Collections.max(Arrays.asList(playerList.get(0).getCoins(), playerList.get(1).getCoins(),
					playerList.get(2).getCoins()));
			System.out.println(" has earned " + playerList.get(3).getCoins() + " coins.");
		}
		if(playerList.size() == 4)
		{
			largest = Collections.max(Arrays.asList(playerList.get(0).getCoins(), playerList.get(1).getCoins(),
					playerList.get(2).getCoins(), playerList.get(3).getCoins()));
			System.out.println(" has earned " + playerList.get(4).getCoins() + " coins.");
		}

		if(playerList.size() == 5)
		{
			largest = Collections.max(Arrays.asList(playerList.get(0).getCoins(), playerList.get(1).getCoins(),
					playerList.get(2).getCoins(), playerList.get(3).getCoins(), playerList.get(4).getCoins()));
		}

		if(playerList.get(0).getCoins() == largest)
		{
			System.out.println("A: Congrats " + ", you won!");
		}

		if(playerList.get(1).getCoins() == largest)
		{
			System.out.println("A: Congrats " + ", you won!");
		}

		if(playerList.get(2).getCoins() == largest)
		{
			System.out.println("A: Congrats " + ", you won!");
		}

		if(playerList.get(3).getCoins() == largest)
		{
			System.out.println("A: Congrats " + ", you won!");
		}

		if(playerList.get(4).getCoins() == largest)
		{
			System.out.println("A: Congrats " + ", you won!");
		}
	}

	//Getters and Setters below this line ---------------------------------------------------

	public Decline getDecline() {
		return decline;
	}

	public void setDecline(Decline decline) {
		this.decline = decline;
	}

	public SpecialPlaceListCreator getSpecialPlaceList() {
		return specialPlaceList;
	}

	public void setSpecialPlaceList(SpecialPlaceListCreator specialPlaceList) {
		this.specialPlaceList = specialPlaceList;
	}

	public int getMaxTotalTurns() {
		return maxTotalTurns;
	}

	public void setMaxTotalTurns(int maxTotalTurns) {
		this.maxTotalTurns = maxTotalTurns;
	}

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

	public CombatController_old getCc() {
		return cc;
	}

	public void setCc(CombatController_old cc) {
		this.cc = cc;
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

	public void setToc(TokenController toc)
	{
		this.toc = toc;
	}

	public TokenController getToc()
	{
		return toc;
	}
}
