package controllers;

import java.util.List;

import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Hand;
import player.Player;
import setup.MapCreator;
import races.Race;
/**
 * Deze klasse is verantwoordelijk voor het beeindigen van de speler zijn beurt.
 * @author Marinus van den Oever
 */
public class EndTurnController
{
	private int terrainIncome;
	private int totalSum;
	private int coins;
	private int newBalance;
	private int abilityIncome;
	private int raceIncome;
	private int relicIncome;
	private int specialPlaceIncome;

	private List<Player> playerList;

	AbilityListCreator abilityList = new AbilityListCreator();
	Map map;
	Player activePlayer;
	Ammy ammy;

	public EndTurnController(Ammy ammy)
	{
		this.ammy = ammy;
		this.map = ammy.getMap();
		this.playerList = ammy.getPlayerList();
	}

	/**
	 * Berekent de totale inkomsten.
	 * @param activePlayer, de actieve speler.
	 */
	public void start(Player activePlayer)
	{

		System.out.println("A: ~~~~~~~~~~~~~~~Calculating coins~~~~~~~~~~~~~~~~~~~`");
		this.activePlayer = activePlayer;
		calculateTerrainIncome();
		calculateRelicIncome();
		calculateSpecialPlaceIncome();
		calculateAbilityIncome();
		calculateRaceIncome();
		addSum();
		calculateNewBalance();
	}

	/**
	 * Berekend de inkomsten van alle terreinen die de speler heeft.
	 */
	public void calculateTerrainIncome()
	{
		terrainIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrains().get(terrainCounter).getRace()))
			{
				terrainIncome++;
			}
		}
		System.out.println("A: " +  " gets " + terrainIncome + " amount of coins from their terrains.");
	}

	/**
	 * Berekend de inkomsten van alle relics die de speler heeft.
	 */
	public void calculateRelicIncome(){

		System.out.println("A: gets " + relicIncome + " amount of coins from their relics.");
	}

	/**
	 * Berekend de inkomsten van alle specialPlaces die de speler heeft.
	 */
	public void calculateSpecialPlaceIncome(){

		System.out.println("A: " + " gets " + specialPlaceIncome + " amount of coins from their Special Places.");
	}

	/**
	 * Berekend de inkomsten van alle ras-abilities die de speler heeft.
	 */
	public void calculateRaceIncome()
	{
		System.out.println("A: " +  " gets " + raceIncome + " amount of coins from their race ability.");
	}
	/**
	 * Berekend de inkomsten van alle abilities die de speler heeft.
	 */
	public void calculateAbilityIncome()
	{
		System.out.println("A: Player one got the " + activePlayer.getActiveSet().getAbility().getName() + " ability now.");

		activePlayer.getActiveSet().getAbility().processAbility(ammy);

		abilityIncome = activePlayer.getActiveSet().getAbility().getAbilityIncome();

		System.out.println("A: " +  " gets " + abilityIncome + " amount of coins from their ability ability.");

	}

	/**
	 * Voegt alle inkomsten samen.
	 */
	public void addSum()
	{

		totalSum = getTerrainIncome() + getAbilityIncome() + getRaceIncome() + getRelicIncome() + getSpecialPlaceIncome();
		System.out.println("A: Making for " + totalSum + " total income.");
	}

	/**
	 * Berekend de nieuwe balans van munten van de speler.
	 */
	public void calculateNewBalance()
	{
		newBalance = activePlayer.getCoins() + getTotalSum();
		activePlayer.setCoins(newBalance);

		System.out.println("A: So, " + "'s total will get to be " + activePlayer.getCoins());
	}

	public int getTerrainIncome() {
		return terrainIncome;
	}

	public void setTerrainIncome(int terrainIncome) {
		this.terrainIncome = terrainIncome;
	}

	public int getRelicIncome() {
		return relicIncome;
	}

	public void setRelicIncome(int relicIncome) {
		this.relicIncome = relicIncome;
	}

	public int getSpecialPlaceIncome() {
		return specialPlaceIncome;
	}

	public void setSpecialPlaceIncome(int specialPlaceIncome) {
		this.specialPlaceIncome = specialPlaceIncome;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	public int getRaceIncome() {
		return raceIncome;
	}

	public void setRaceIncome(int raceIncome) {
		this.raceIncome = raceIncome;
	}
}
