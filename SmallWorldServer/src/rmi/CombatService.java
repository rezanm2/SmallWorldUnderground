package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Player;
import server.CombatServiceSkeleton;

public class CombatService  extends UnicastRemoteObject implements CombatServiceSkeleton{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CombatService(ArrayList<Player> playerList) throws RemoteException {
		super();

	}

}
