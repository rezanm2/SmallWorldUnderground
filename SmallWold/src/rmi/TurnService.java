package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.ClientSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;


public class TurnService extends UnicastRemoteObject implements TurnServiceClientSkeleton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TurnService() throws RemoteException {
	}

	@Override
	public void updatePlayerTurn(String player) {
		System.out.println("current players turn: " + player);

	}

	@Override
	public void StartTurn() {
		System.out.println("iTS YOUR TURN!!!");


	}






}
