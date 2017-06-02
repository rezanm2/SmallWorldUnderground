package controllers;

import playBoard.Map;
import player.Player;

public class EndTurnController
{
	private int amountOfTerrains;
	private int terrainIncome;
	private int abilityIncome;
	private int raceIncome;
	private int relicIncome;
	private int specialPlaceIncome;
	private int totalSum;
	Map map = new Map();

	public EndTurnController(Map map)
	{
		this.map = map;
	}

	public void calculateTerrainIncome(Player player){
		amountOfTerrains = 0;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			if (player.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace())){
				amountOfTerrains++;

			}
		}
	}

	public void calculateAbilityIncome(Player player){

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
