package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;
/**
 * Deze klasse is verantwoordelijk voor het regelen van de terreinstatussen.
 * @author Jeroen Zandvliet
 */
public class TerrainController
{
	private int terrainCounter;
	private Player activePlayer;
	private Map map;
	private int elementCounter = 0;
	private int terrain = 0;

	private int typeTerrainCounter;
	private int value = 0;
	private boolean validChoice;
	private int areaPicked;
	private int returnedTokens;
	private int terrainStringCounter;
	private ArrayList<Integer> Terrainslist = new ArrayList<Integer>();
	Scanner input = new Scanner(System.in);

	public TerrainController(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
	}



	/**
	 * Zet alle terreinen op aangrenzend.
	 * @param activePlayer, de speler waarvan de terreinen aangrezend gezet moeten worden.
	 */
	public void setAllAdjacentAreas(Player activePlayer)
	{
		setNotAdjacent();
		System.out.println("A: Setting all adjacent terrains for " + "\n");
		this.activePlayer = activePlayer;

//		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
//		{
//			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace())) //For every land that's the current player's
//			{
//				changeAllAdjacentAreas(map.getTerrain(terrainCounter).getElement(0));
//			}
//		}
	}

	/**
	 * Zet all terreinen op aangrenzend.
	 * @param code, de code van het terrein waarmee vergeleken moet worden.
	 */
	public void changeAllAdjacentAreas(String code)
	{
		for(terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)
		{
//			for(elementCounter = 1; elementCounter<map.getTerrain(terrainCounter).getIdArray().length; elementCounter++) //While there's still elements left
//			{
//				if(map.getTerrain(terrainCounter).getElement(elementCounter) == code)
//				{
//					map.getTerrain(terrainCounter).setIsAdjacent(true);			//If the idCode is found, set isAdjacent to true
//				}
//			}
		}
	}
	/**
	 * Zet all terreinen op aanvalbaar.
	 * @param activePlayer, de speler waarvan de terreinen aanvalbaar gezet moeten worden.
	 */
	public void setAllAttackableAreas(Player activePlayer)
	{
		setNotAttackable();
		System.out.println("A: Setting all attackable terrains for " + "\n");
		this.activePlayer = activePlayer;
//		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
//		{
//			if(activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
//			{
//				changeAllAttackableAreas(map.getTerrain(terrainCounter).getElement(0));
//			}
//		}
	}

	/**
	 * Zet all terreinen op aanvalbaar.
	 * @param code, de code van het terrein waarmee vergeleken moet worden.
	 */
	private void changeAllAttackableAreas(String code)
	{
//		for(terrainCounter = 0; terrainCounter<map.getAllTerrains().size(); terrainCounter++)
//		{
//			for(elementCounter = 1; elementCounter<map.getTerrain(terrainCounter).getIdArray().length-1; elementCounter++) //While there's still elements left
//			{
//				if(map.getTerrain(terrainCounter).getElement(elementCounter) == code
//						&& !map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
//				{
//					map.getTerrain(terrainCounter).setIsAttackable(true);			//If the idCode is found, set isAdjacent to true
//
//				}
//			}
//		}
	}
	/**
	 * Zet all terreinen op heraanvulbaar.
	 * @param activePlayer, de speler wiens terreinen op heraanvulbaar gezet moeten worden.
	 */
	public void setAllRedeployableAreas(Player activePlayer)
	{
		setNotRedeployable();
		System.out.println("A: Setting all reinforcable terrains for " + "\n");
		this.activePlayer = activePlayer;
//		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
//		{
//			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
//			{
//				map.getTerrain(terrainCounter).setIsRedeployable(true);
//			}
//		}

	}


	/**
	 * Zet alle terreinen op niet aangrenzend.
	 */
	public void setNotAdjacent()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsAdjacent(false);		//Set it to false
		}
	}

	/**
	 * Zet alle terreinen op niet aanvalbaar.
	 */
	public void setNotAttackable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsAttackable(false);		//Set it to false
		}
	}
	/**
	 * Zet alle terreinen op niet heraanvulbaar.
	 */
	public void setNotRedeployable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrains().get(terrainCounter).setIsRedeployable(false);		//Set it to false
		}
	}

	/**
	 * Checked of een terrein aangrenzend is aan het meegegeven type terrein.
	 * @param terrainString, het type terrein.
	 */
	public void checkAdjacentToTerrainType(String terrainString)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)
		{
			if(map.getTerrains().get(typeTerrainCounter).getTerrainName().equals(terrainString))
			{
				changeAllAdjacentAreas(map.getTerrains().get(typeTerrainCounter).getElement(0));

				System.out.println("A: Beeping area (ArrayListPosition) " + (typeTerrainCounter+1));
			}
		}
		excludeAdjacent(terrainString);
	}

	/**
	 * Checked welke terreinen aangrenzen zijn aan 1 terrein
	 * @param terrain, het terrein.
	 */
	public void checkAdjacentToSingleTerrain(Terrain terrain)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)	//As long as there's terrains
		{
			changeAllAdjacentAreas(terrain.getElement(0));
		}
	}

	/**
	 * Verwijdert het eigen terrein van "adjacent".
	 * @param terrainType, het type dat meegegeven wordt.
	 */
	public void excludeAdjacent(String terrainType)
	{
		for(typeTerrainCounter = 0; typeTerrainCounter<map.getTerrains().size(); typeTerrainCounter++)
		{
			if(map.getTerrains().get(typeTerrainCounter).getIsAdjacent() == true && map.getTerrains().get(typeTerrainCounter).getTerrainName() == terrainType)
			{
				map.getTerrains().get(typeTerrainCounter).setIsAdjacent(false);
			}
		}
	}



	/**
	 * Berekend op hoeveel terreinen van het meegegeven type de meegegeven speler zit.
	 * @param terrainString, het type terrein.
	 * @param activePlayer, de speler.
	 */
	public void checkTerrainType(String terrainString, Player activePlayer)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;
		terrainStringCounter = 0;
		while(terrainCounter<map.getTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<1)		//While there's still numbers in the terrain's array
			{
				if(map.getTerrains().get(terrain).getTerrainName().equals(terrainString) && map.getTerrains().get(terrain).getRace() == activePlayer.getActiveSet().getRace())
				{
					terrainStringCounter++;
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


	public int getReturnedTokens() {
		return returnedTokens;
	}

	public void setReturnedTokens(int returnedTokens) {
		this.returnedTokens = returnedTokens;
	}

	public int getAreaPicked() {
		return areaPicked;
	}

	public void setAreaPicked(int areaPicked) {
		this.areaPicked = areaPicked;
	}

	public int getTerrainStringCounter()
	{
		return terrainStringCounter;
	}
	public void setTerrainStringCounter(int terrainStringCounter)
	{
		this.terrainStringCounter = terrainStringCounter;
	}

	public ArrayList<Integer> getTerrainslist() {
		return Terrainslist;
	}

	public void setTerrainslist(ArrayList<Integer> terrainslist) {
		Terrainslist = terrainslist;
	}


}
