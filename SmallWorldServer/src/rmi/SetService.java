package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Abilities;
import data.Player;
import data.Races;
import server.SetServiceClientSkeleton;
import server.SetServiceSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;

public class SetService extends UnicastRemoteObject implements SetServiceSkeleton {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<SetServiceClientSkeleton> setClientList = new ArrayList<>();
	private Races races;
	private Abilities abilities;
	private int amountPlayers;


	public SetService(ArrayList<Player> playerList) throws RemoteException {
		super();
		this.amountPlayers = playerList.size();
		races = new Races();
		races.shuffleMain();
		abilities = new Abilities();
		abilities.shuffleMain();


	}

	@Override
	public void addSetClient(SetServiceClientSkeleton setClient) throws RemoteException {

		this.setClientList.add(setClient);
		if (setClientList.size() == amountPlayers){
			new Thread(() -> {
				try {

					updateClientRaceList();

				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}).start();

		}

	}
	public void updateClientRaceList() throws RemoteException{
		for (SetServiceClientSkeleton setClient : setClientList) {
			setClient.updateStackList(races.getRaceList(), abilities.getAbilityList());
		}
	}

}
