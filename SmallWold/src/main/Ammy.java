//Deze klasse bestaat nog ivm bugs maar wordt niet meer gebruikt.

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
import player.Player;
import terrain.Terrain;

public class Ammy
{
	//This entire list is just for references, for the setters and getters of Ammy.
	CombatController_old cc;
	Map map;
	EndTurnController etc;
	Player activePlayer;
	List<Player> playerList;
	TerrainController tc;
	Die die = new Die();
	AbilityListCreator abilityList;
	RaceListCreator raceList;
	RelicListCreator relicList;
	SpecialPlaceListCreator specialPlaceList;
	Scanner input = new Scanner(System.in);
	private int largest;
	private int choice;
	int maxTotalTurns;
	TokenController toc;

	public void playerSetup()		//This method sets up the players, the amount of Players, and their names.
	{

		System.out.println("Ammy: I'm running! \n");
		System.out.println("Ammy: I'm done creating all of your players.");
		this.createAccordingMap();
	}

	public void createAccordingMap()	//This method sets up the map, the appropriate one for how many players were selected.
	{

		System.out.println("Created map.");
		System.out.println("Ammy: I'm done creating the according map.");
	}



	public void createCreators()		//This method creates all the creators, for future reference.
	{
		System.out.println("Ammy: I'm creating all the creators. \n" );
		tc = new TerrainController(this);

		toc = new TokenController(this);
		cc = new CombatController_old(this);
		etc = new EndTurnController(this);
		System.out.println("Ammy: Done creating creators... \n");
		System.out.println("A: I'm starting your game... \n");
	}

	public void createLists()
	{
		abilityList = new AbilityListCreator();
		raceList = new RaceListCreator();
		relicList = new RelicListCreator();
		specialPlaceList = new SpecialPlaceListCreator();

	}

	public void setEverythingOnAmmy()
	{
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


	public CombatController_old getCc() {
		return cc;
	}

	public void setCc(CombatController_old cc) {
		this.cc = cc;
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
