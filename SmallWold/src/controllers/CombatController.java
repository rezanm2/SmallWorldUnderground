package controllers;

import java.util.List;
import java.util.Scanner;

import listCreators.RaceListCreator;
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
	private int value;
	private char rollDice;
	private boolean diceUsed;
	private Race losingRace;
	private Terrain terrain;
	private int miscModifier = 0;
	RaceListCreator raceList;
	Player losingPlayer;
	List playerList;
	Die die;
	Player activePlayer;
	Map map;
	TerrainController tc;
	TokenController toc;
	Scanner input = new Scanner(System.in);
	private Ammy ammy;

	public CombatController(Ammy ammy)
	{
		this.die = ammy.getDie();
		this.map = ammy.getMap();
		this.tc = ammy.getTc();
		this.toc = ammy.getToc();
		this.playerList = ammy.getPlayerList();
		this.raceList = ammy.getRaceList();
		this.ammy = ammy;
	}

	public void calculateCombat(Terrain terrain, Player activePlayer)		//Calculating win or lose
	{
		this.terrain = terrain;
		this.activePlayer = activePlayer;

		if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredAmountOfTokens + miscModifier)	//If the player wins
		{
			doAttack(terrain, activePlayer);
		}
		else																					//If the player loses
		{
			System.out.println("A: Not enough tokens selected. Wanna roll a die? ( (Y)es / (N)o )");
			rollDice = input.nextLine().toString().toUpperCase().charAt(0);
			System.out.println(rollDice);
			if(rollDice == 'Y' || rollDice == 'Z' || rollDice == 'X' || rollDice == 'C' || rollDice == 'V')
			{
				rollConquestDie();
			}
			else if(rollDice == 'N')
			{
				System.out.println("A: Ah okay, I will cancel the attack then. ");
			}

			else
			{
				System.out.println("A: I didn't understand what you want me to do, so I am cancelling the attack. ");
			}
		}
	}

	public void doAttack(Terrain terrain, Player activePlayer) {
		losingRace = terrain.getRace();
		toc.linkRaceToPlayer(losingRace);
		losingPlayer = toc.getRacesPlayer();

		if(miscModifier > 20){
			losingPlayer.getHand().setCurrentTokens(losingPlayer.getHand().getCurrentTokens() + (terrain.getAmountOfTokens())); //Calculate loss

			System.out.println("A: StinkyTrollSocks in effect");

			System.out.println("A: " +  " just lost combat. Now has: " + losingPlayer.getHand().getCurrentTokens()
					+ " in hand, because " + terrain.getAmountOfTokens() + " were returned to his hand.");
		}
		else if(!terrain.getRace().equals(raceList.getListElement(0)))
		{
			losingPlayer.getHand().setCurrentTokens(losingPlayer.getHand().getCurrentTokens() + (terrain.getAmountOfTokens() - 1)); //Calculate loss

			System.out.println("A: " +  " just lost combat. Now has: " + losingPlayer.getHand().getCurrentTokens()
					+ " in hand, because " + terrain.getAmountOfTokens() + " - 1 were returned to his hand.");
		}
		else
		{
			System.out.println("A: The terrain was empty, so no tokens are returned.");
		}


		terrain.setRace(activePlayer.getActiveSet().getRace());	 							//Make the terrain be the player's Race
		terrain.setAmountOfTokens(declaredAmountOfTokens);							  		//The declared amount is set on the terrain
		System.out.println("A: Attack succesful!");
		tc.setNotAdjacent();
		tc.setNotAttackable();
		tc.setNotRedeployable();
		tc.setAllAttackableAreas(activePlayer);
		tc.setAllAdjacentAreas(activePlayer);
		tc.setAllRedeployableAreas(activePlayer);

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() - declaredAmountOfTokens);
		miscModifier = 0;
	}

	public void rollConquestDie()
	{

		if(rollDice == 'Z')
		{
			die.setResult(1);
			System.out.println("A: Wow, you miraculously rolled a " + die.getResult() + ". How lucky.");
		}
		else if(rollDice == 'X')
		{
			die.setResult(2);
			System.out.println("A: Wow, you miraculously rolled a " + die.getResult() + ". How lucky.");
		}
		else if(rollDice == 'C')
		{
			die.setResult(3);
			System.out.println("A: Wow, you miraculously rolled a " + die.getResult() + ". How curious.");
		}

		else if(rollDice == 'V')
		{
			die.setResult(4);
			System.out.println("A: Okay, man, you really can't roll a " + die.getResult() + " on this die. That's just cheating.");
		}
		else
		{
			System.out.println("A: So you want to roll the die, great! ");
			die.throwDie();
			System.out.println("A: Let's see what you rolled: " + die.getResult() + "\n");
		}

		if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredAmountOfTokens + die.getResult() + miscModifier)
		{
			System.out.println("A: The die CANT TALK. But you can take the terrain! ");
			doAttack(terrain, activePlayer);
			System.out.println("A: Ending your conquest phase");
			diceUsed = true;
		}
		else
		{
			System.out.println("A: Ayyy thats too bad. ");
			System.out.println("A: Ending your conquest phase");
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


	public boolean isDiceUsed() {
		return diceUsed;
	}

	public void setDiceUsed(boolean diceUsed) {
		this.diceUsed = diceUsed;
	}

	public Race getLosingRace() {
		return losingRace;
	}

	public void setLosingRace(Race losingRace) {
		this.losingRace = losingRace;
	}

	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
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


	public void setDeclaredAmountOfTokens(int declaredAmountOfTokens)				//Player declaring amount of tokens for attack
	{
		this.declaredAmountOfTokens = declaredAmountOfTokens;
	}

	public int getMiscModifier() {
		return miscModifier;
	}

	public void setMiscModifier(int miscModifier) {
		this.miscModifier = miscModifier;
	}
}
