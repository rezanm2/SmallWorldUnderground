package controllers;

import java.util.List;

import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Hand;
import player.Player;
import setup.MapCreator;

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

	public void calculateTerrainIncome(Ammy ammy)
	{
		this.activePlayer = ammy.getPlayerList().get(0);
		terrainIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				terrainIncome++;
			}
		}
	}


	public void checkTerrainType(String terrainString)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;
		terrainStringCounter = 0;
		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)		//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getTerrainName().equals(terrainString)) 		//If the idCode is found, set isAttackable to true
				{
					terrainStringCounter++;
					System.out.println("A: " + (terrain+1) + " is a " + terrainString);
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				elementCounter++;									//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			elementCounter = 0;										//Back at number 0 in a fresh terrain
			terrainCounter++;										//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
	}

	public void calculateRelicIncome(Player player){

	}

	public void calculateSpecialPlaceIncome(Player player){

	}

	public void getAbilityIncome()
	{
		ammy.getPlayerList().get(0).getActiveSet().getAbility().calculateAbility();
	}

	public void addSum(){
		getTerrainIncome() +

		totalSum = this.getTerrainIncome() + this.getAbilityIncome() + this.getRaceIncome() + this.getRelicIncome() + this.getSpecialPlaceIncome();
	}

	public void calculateNewBalance(int coins){
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
