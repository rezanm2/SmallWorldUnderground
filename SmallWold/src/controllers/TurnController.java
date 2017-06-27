package controllers;

import java.rmi.RemoteException;

import playBoard.Map;
import player.Player;
import server.TurnServiceSkeleton;
import views.sideBarView.SideBarController;

/**
 * Deze controllerClass bepaalt hoeveel coins de speler krijgt aan het eind van zijn/haar beurt.
 *
 * @author Wim van der Putten, Marinus van den Oever
 *
 */

public class TurnController {

	private Map map;
	private SideBarController sideBarController;
	private int terrainCounter;
	private int terrainIncome;
	private int newBalance;
	private TurnServiceSkeleton turnServer;
	private int phase; //needs to be an enum but i am  (0 = start )(1 = redeployment ) (2 = WAITING)

	/**
	 * De constructor van de turnController.
	 * Hierbij wordt eerst de map geset en daarna de sideBarConroller.
	 * Vervolgens de turnController zelf aan de sideBarController meegegeven.
	 *
	 * @param map, de map van het spel.
	 * @param sideBarController, de controller van de sideBarView.
	 */
	public TurnController(Map map, SideBarController sideBarController, TurnServiceSkeleton turnServer) {
		this.map = map;
		this.sideBarController = sideBarController;
		sideBarController.setTurnController(this);
		this.phase = 0;
		this.turnServer = turnServer;
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

	public void CalculateTerrainIncome(){
		terrainIncome = 0;
		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)
		{
			if(map.getSelfPlayer().getActiveSet().getRace().equals(map.getTerrains().get(terrainCounter).getRace()))
			{
				terrainIncome++;
			}
		}
	}
	public void start(){
		this.phase = 0;
	}
	public int getTerrainIncome() {
		return terrainIncome;
	}

	public void setTerrainIncome(int terrainIncome) {
		this.terrainIncome = terrainIncome;
	}

	public void endPhase() throws RemoteException {
		if(map.getSelfPlayer().isMyTurn()){
			switch (this.phase)
			{

			case 0:
				if(this.map.getSelfPlayer().getActiveSet() != null){
				System.out.println("client: going to redeployment phase");
				this.phase = 1;
				sideBarController.hideDeclineButton();
				sideBarController.updateButtonText("End TURN");

				//do things for redeployment
				} else{
					System.out.println("CANT END TURN NO SET");
				}
				break;
			case 1:
				System.out.println("client: ending turn");
				sideBarController.updateButtonText("");
				this.phase = 0;
				this.map.getSelfPlayer().setMyTurn(false);
				this.calculateNewBalance();
				this.turnServer.endTurn();

				break;

			default:
				break;
			}
		}
	}


}
