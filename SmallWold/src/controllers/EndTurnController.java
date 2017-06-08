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
	private int relicIncome;
	private int specialPlaceIncome;
	private int totalSum;
	private int coins;
	private int terrainCounter;
	private int terrainStringCounter;
	private int elementCounter;
	private int terrain;
	private int value;
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

	public void calculateTerrainIncome(Player activePlayer)
	{
		this.activePlayer = activePlayer;
		terrainIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				terrainIncome++;
			}
		}
	}




	public void calculateRelicIncome(Player activePlayer){

	}

	public void calculateSpecialPlaceIncome(Player activePlayer){

	}

	public void calculateAbilityIncome(Player activePlayer)
	{
		this.activePlayer = activePlayer;
		ammy.getPlayerList().get(0).getActiveSet().setAbility(abilityList.getListElement(10));
		System.out.println("A: Player one got " + activePlayer.getActiveSet().getAbility().getName() + " now.");


		ammy.getPlayerList().get(0).getActiveSet().getAbility().processAbility(activePlayer);


		System.out.println("A: " + activePlayer.getName() + " gets " + activePlayer.getActiveSet().getAbility().getAbilityIncome()
							+ " coins from their ability trait.");

	}

	public void addSum(){

	//	totalSum = this.getTerrainIncome() + this.getAbilityIncome() + this.getRaceIncome() + this.getRelicIncome() + this.getSpecialPlaceIncome();

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
}
