package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.SetService;

public interface SetServiceClientSkeleton  extends Remote{

	void updateStackList(ArrayList<String> raceList, ArrayList<String> abilityList) throws RemoteException;

	void costList(ArrayList<Integer> gains) throws RemoteException;

	void updateSetsPlayer2(String playerNames, String playerRaces, String playerAbilities, int amountPlayer) throws RemoteException;
	void updateSetsPlayer1(String playerNames, String playerRaces, String playerAbilities, int amountPlayer) throws RemoteException;

}
