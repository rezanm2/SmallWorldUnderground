package controllers;

import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;
import races.Race;

public class CombatController
{
	private int declaredAmountOfTokens;
	private int terrainCounter;
	private int terrainStringCounter;
	private int elementCounter;
	private int terrain;
	private int value;
	Player activePlayer;
	Map map;


	public CombatController(Ammy ammy)
	{
		this.map = ammy.getMap();
	}

	public void setAllAdjacentAreas(Player activePlayer)
	{
		System.out.println("A: Setting all adjacent terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace())) //For every land that's the current player's
			{
				changeAllAdjacentAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}
	}

	private void changeAllAdjacentAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code)
				{
					map.getTerrain(terrain).setIsAdjacent(true);			//If the idCode is found, set isAttackable to true
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



	public void setAllAttackableAreas(Player activePlayer)
	{
		System.out.println("A: Setting all attackable terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				changeAllAttackableAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}
	}

	private void changeAllAttackableAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code && !map.getTerrain(terrain).getRace().equals(
						activePlayer.getActiveSet().getRace()))
				{
					map.getTerrain(terrain).setIsAttackable(true);			//If the idCode is found, set isAttackable to true
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

	public void setAllReinforcableAreas(Player activePlayer)
	{
		System.out.println("A: Setting all reinforcable terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				changeAllReinforcableAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}

	}

	private void changeAllReinforcableAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code && map.getTerrain(terrain).getRace().equals(
						activePlayer.getActiveSet().getRace()))
				{
					map.getTerrain(terrain).setIsReinforcable(true);			//If the idCode is found, set isAttackable to true
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


	public void setDeclaredAmountOfTokens(int declaredAmountOfTokens)				//Player declaring amount of tokens for attack
	{
		this.declaredAmountOfTokens = declaredAmountOfTokens;
	}

	public void calculateCombat(Terrain terrain, Player activePlayer)		//Calculating win or lose
	{
		if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredAmountOfTokens)	//If the player wins
		{
			terrain.setRace(activePlayer.getActiveSet().getRace());	 							//Make the terrain be the player's Race
			terrain.setAmountOfTokens(declaredAmountOfTokens);							  		//The declared amount is set on the terrain
			System.out.println("A: Attack succesful!");
			setAllAttackableAreas(activePlayer);
			setAllAdjacentAreas(activePlayer);
			setAllReinforcableAreas(activePlayer);
		}
		else																					//If the player loses
		{
			System.out.println("A: Not enough tokens selected. Wanna roll a die?");
			//Roll conquest die or attack something different
		}
	}

	public void setNotAdjacent()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsAdjacent(false);		//Set it to false
		}
	}

	public void setNotAttackable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsAttackable(false);		//Set it to false
		}
	}

	public void setNotReinforcable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsReinforcable(false);		//Set it to false
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

	public int getTerrainCounter() {
		return terrainCounter;
	}


	public void setTerrainCounter(int terrainCounter) {
		this.terrainCounter = terrainCounter;
	}


	public int getTerrainStringCounter() {
		return terrainStringCounter;
	}


	public void setTerrainStringCounter(int terrainStringCounter) {
		this.terrainStringCounter = terrainStringCounter;
	}


	public int getElementCounter() {
		return elementCounter;
	}


	public void setElementCounter(int elementCounter) {
		this.elementCounter = elementCounter;
	}


	public int getTerrain() {
		return terrain;
	}


	public void setTerrain(int terrain) {
		this.terrain = terrain;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Player getActivePlayer() {
		return activePlayer;
	}


	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public int getDeclaredAmountOfTokens() {
		return declaredAmountOfTokens;
	}
}
