package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Races;
import server.SetServiceClientSkeleton;
import server.SetServiceSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;

public class SetService extends UnicastRemoteObject implements SetServiceSkeleton {


	private ArrayList<SetServiceClientSkeleton> setClientList = new ArrayList<>();
	private Races races;
	private int amountPlayers;

	public SetService(int amountPlayers) throws RemoteException {
		super();
		this.amountPlayers = amountPlayers;
		races = new Races();
		races.shuffleMain();


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
			setClient.updateRaceList(races.getRaceList());
		}
	}

}
