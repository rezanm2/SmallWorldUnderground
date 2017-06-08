package controllers;

import java.util.List;

import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Hand;
import player.Player;
import setup.MapCreator;
import races.Race;

public class EndTurnController
{
	private int terrainIncome;
	private int totalSum;
	private int coins;
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

	public void start(Player activePlayer)
	{
		this.activePlayer = activePlayer;
		calculateTerrainIncome();
		calculateRelicIncome();
		calculateSpecialPlaceIncome();
		calculateAbilityIncome();
		calculateRaceIncome();
		addSum();
	}

	public void calculateTerrainIncome()
	{
		terrainIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				terrainIncome++;
			}
		}
		System.out.println("A: " + activePlayer.getName() + " gets " + terrainIncome + " amount of coins from their terrains.");
	}

	public void calculateRelicIncome(){

		System.out.println("A: " + activePlayer.getName() + " gets " + relicIncome + " amount of coins from their relics.");
	}

	public void calculateSpecialPlaceIncome(){

		System.out.println("A: " + activePlayer.getName() + " gets " + specialPlaceIncome + " amount of coins from their Special Places.");
	}

	public void calculateRaceIncome()
	{
		System.out.println("A: " + activePlayer.getName() + " gets " + raceIncome + " amount of coins from their race ability.");
	}
	public void calculateAbilityIncome()
	{
		System.out.println("A: Player one got the " + activePlayer.getActiveSet().getAbility().getName() + " ability now.");
		activePlayer.getActiveSet().getAbility().processAbility(ammy);
		System.out.println("A: " + activePlayer.getName() + " gets " + abilityIncome + " amount of coins from their ability ability.");

	}

	public void addSum()
	{

	totalSum = getTerrainIncome() + getAbilityIncome() + getRaceIncome() + getRelicIncome() + getSpecialPlaceIncome();

	}

	public void calculateNewBalance(int currentBalance, int totalIncome){
	coins = playerList.get(0).getCoins() + this.getTotalSum();
	playerList.get(0).setCoins(coins);
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
