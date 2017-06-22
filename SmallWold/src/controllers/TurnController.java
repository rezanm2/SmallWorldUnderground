package controllers;

import playBoard.Map;
import player.Player;
import views.sideBarView.SideBarController;

public class TurnController {

	private Map map;
	private SideBarController sideBarController;
	private int terrainCounter;
	private int terrainIncome;
	private int newBalance;

	public TurnController(Map map, SideBarController sideBarController) {
		this.map = map;
		this.sideBarController = sideBarController;
		sideBarController.setTurnController(this);
	}

	public void calculateNewBalance(){
		CalculateTerrainIncome();
		newBalance = map.getSelfPlayer().getCoins() + getTerrainIncome();
		map.getSelfPlayer().setCoins(newBalance);
		System.out.println("De player ontvangt " + map.getSelfPlayer().getCoins() + " coins van zijn overgenomen terreinen. ");

	}

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
