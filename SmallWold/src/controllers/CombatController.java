package controllers;

import java.util.Scanner;

import main.Ammy;
import playBoard.Die;
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
	Die die;
	Player activePlayer;
	Map map;
	TerrainsController tc;

	public CombatController(Ammy ammy)
	{
		this.die = ammy.getDie();
		this.map = ammy.getMap();
		this.tc = ammy.getTc();
	}



	public void setDeclaredAmountOfTokens(int declaredAmountOfTokens)				//Player declaring amount of tokens for attack
	{
		this.declaredAmountOfTokens = declaredAmountOfTokens;
	}

	public void calculateCombat(Terrain terrain, Player activePlayer)		//Calculating win or lose
	{
		if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredAmountOfTokens)	//If the player wins
		{
			doAttack(terrain, activePlayer);
		}
		else																					//If the player loses
		{
			System.out.println("A: Not enough tokens selected. Wanna roll a die? ( (Y)es / (N)o )");
			Scanner input = new Scanner(System.in);
			char rollDice = input.nextLine().toString().toUpperCase().charAt(0);
			System.out.println(rollDice);
			if(rollDice == 'Y') {
				System.out.println("A: So you want to roll the die, great! ");
				die.throwDie();
				System.out.println("A: Let's see what you rolled: " + die.getResult() + "\n");
				if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredAmountOfTokens + die.getResult()) {
					System.out.println("A: The die says you can take the terrain! ");
					doAttack(terrain, activePlayer);
					System.out.println("A: Ending your conquestfase");
				}
				else {
					System.out.println("A: Ai thats to bad. ");
					System.out.println("A: Ending your conquestfase");
				}
			}
			else if(rollDice == 'N') {
				System.out.println("A: Ah okey, I will cancel the attack than. ");
			}
			else {
				System.out.println("A: I didn't understand what you want me to do, so I am cancelling the attack. ");
			}
		}
	}

	public void doAttack(Terrain terrain, Player activePlayer) {
		terrain.setRace(activePlayer.getActiveSet().getRace());	 							//Make the terrain be the player's Race
		terrain.setAmountOfTokens(declaredAmountOfTokens);							  		//The declared amount is set on the terrain
		System.out.println("A: Attack succesful!");
		tc.setAllAttackableAreas(activePlayer);
		tc.setAllAdjacentAreas(activePlayer);
		tc.setAllReinforcableAreas(activePlayer);
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
			while(elementCounter<1)		//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getTerrainName().equals(terrainString))
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
