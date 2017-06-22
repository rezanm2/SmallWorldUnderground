package controllers;

import playBoard.Map;
import player.Player;
import views.sideBarView.SideBarController;

/**
 * Deze controllerClass bepaalt hoeveel coins de speler krijgt aan het eind van zijn/haar beurt.
 * 
 * @author Groep13
 *
 */

public class TurnController {

	private Map map;
	private SideBarController sideBarController;
	private int terrainCounter;
	private int terrainIncome;
	private int newBalance;

	/**
	 * De constructor van de turnController.
	 * Hierbij wordt eerst de map geset en daarna de sideBarConroller.
	 * Vervolgens de turnController zelf aan de sideBarController meegegeven.
	 * 
	 * @param map, de map van het spel.
	 * @param sideBarController, de controller van de sideBarView.
	 */
	public TurnController(Map map, SideBarController sideBarController) {
		this.map = map;
		this.sideBarController = sideBarController;
		sideBarController.setTurnController(this);
	}

	/**
	 * Berekent de nieuwe balans van de speler en update deze vervolgens bij de view.
	 */
	public void calculateNewBalance(){
		CalculateTerrainIncome();
		newBalance = map.getSelfPlayer().getCoins() + getTerrainIncome();
		map.getSelfPlayer().setCoins(newBalance);
		System.out.println("De player ontvangt " + map.getSelfPlayer().getCoins() + " coins van zijn overgenomen terreinen. ");

	}

	/**
	 * Deze methode berekent hoeveel inkomen de speler krijg voor zijn terreinen.
	 */
	public void CalculateTerrainIncome(){
		terrainIncome = 0;
		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++){
			if(map.getSelfPlayer().getActiveSet().getRace().equals(map.getTerrains().get(terrainCounter).getRace())){
				terrainIncome++;
			}
		}
	}

	public int getTerrainIncome() {
		return terrainIncome;
	}

	public void setTerrainIncome(int terrainIncome) {
		this.terrainIncome = terrainIncome;
	}


}
