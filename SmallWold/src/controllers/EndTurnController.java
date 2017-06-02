package controllers;

import listCreators.AbilityListCreator;
import playBoard.Map;
import player.Player;
import setup.MapCreator;

public class EndTurnController
{
	private int incomeOfTerrains;
	private int terrainIncome;
	private int abilityIncome;
	private int raceIncome;
	private int relicIncome;
	private int specialPlaceIncome;
	private int totalSum;
	AbilityListCreator abilityList = new AbilityListCreator();
	Map map = new Map();
	Player activePlayer;

	public EndTurnController(Map map)
	{
		this.map = map;
	}

	public void calculateTerrainIncome(Player activePlayer)
	{
		this.activePlayer = activePlayer;
		incomeOfTerrains = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				incomeOfTerrains++;
			}
		}
	}

	public int getIncomeOfTerrains()
	{
		return incomeOfTerrains;
	}

	public void calculateAbilityIncome(Player activePlayer){
		this.activePlayer = activePlayer;

		if (activePlayer.getActiveSet().getAbility().equals(abilityList.getListElement(1))){ // Adventurous

		}

		if (activePlayer.getActiveSet().getAbility().equals(abilityList.getListElement(2))){ // Fisher
			
			
		}
	}
	public void calculateRaceIncome(Player player){

	}

	public void calculateRelicIncome(Player player){

	}

	public void calculateSpecialPlaceIncome(Player player){

	}

	public void addSum(){

	}

	public void calculateNewBalance(){

	}



	public int getTerrainIncome() {
		return terrainIncome;
	}

	public void setTerrainIncome(int terrainIncome) {
		this.terrainIncome = terrainIncome;
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
