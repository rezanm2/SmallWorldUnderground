package rmi;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controllers.CombatController;
import controllers.RedeploymentController;
import controllers.TurnController;
import javafx.application.Platform;
import player.Player;
import server.ClientSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;
import views.sideBarView.SideBarController;


public class TurnService extends UnicastRemoteObject implements TurnServiceClientSkeleton {

	/**
	 * Deze klasse is verantwoordelijk voor het regelen van de beurten.
	 *@author Wim van der Putten
	 */
	private static final long serialVersionUID = 1L;
	private SideBarController sideBarController;
	private Player selfPlayer;
	private  TurnController turnController;
	private RedeploymentController redeployController;


	public TurnService(Player selfPlayer, SideBarController sideBarController, TurnController turnController, RedeploymentController redeployController) throws RemoteException {
		this.sideBarController = sideBarController;
		this.selfPlayer = selfPlayer;
		this.turnController = turnController;
		this.redeployController = redeployController;
	}

	@Override
	public void updatePlayerTurn(String playerName) {

		selfPlayer.setMyTurn(false);
		System.out.println("its "+ playerName+"'s turn");
		Platform.runLater(() -> {
			sideBarController.UpdateText("Its " +playerName +"'s Turn");
		});
	}

	@Override
	public void StartTurn(int turn) throws RemoteException {

		Platform.runLater(() -> {

			sideBarController.UpdateText("Its your Turn");
			sideBarController.updateButtonText("End conquest");
			sideBarController.showButton();
			if(selfPlayer.getActiveSet() != null){
			sideBarController.showDeclineButton();
			redeployController.turnthingy(turn);
			}
		});

		selfPlayer.setMyTurn(true);
		if(selfPlayer.getActiveSet() != null){
				this.redeployController.prepareFields();
		}
		//SideBarController.
		System.out.println("its my turn");
	}


	@Override
	public String getName() throws RemoteException {
		return this.selfPlayer.getName();
	}






}
