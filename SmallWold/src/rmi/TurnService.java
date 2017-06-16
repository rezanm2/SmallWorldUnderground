package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import player.Player;
import server.ClientSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;
import views.sideBarView.SideBarController;


public class TurnService extends UnicastRemoteObject implements TurnServiceClientSkeleton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SideBarController sideBarController;
	private Player selfPlayer;


	public TurnService(Player selfPlayer) throws RemoteException {
		this.sideBarController = sideBarController;
		this.selfPlayer = selfPlayer;
	}

	@Override
	public void updatePlayerTurn(String playerName) {
		sideBarController.UpdateText("Its " +playerName +"'s Turn");
		selfPlayer.setMyTurn(false);
	}

	@Override
	public void StartTurn() {
		sideBarController.UpdateText("Its your Turn");
		selfPlayer.setMyTurn(true);
	}






}
