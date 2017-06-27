package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
public interface SetServiceSkeleton  extends Remote{


	void addSetClient(SetServiceClientSkeleton setClient) throws RemoteException;

	//void updateSetList(String race, String ability) throws RemoteException;
	void updateDeclineset(String playerName, String race, String ability) throws RemoteException;
	
	void giveAllInformationPlayer(String playerName, int handTokens, int declineTokens, int balance) throws RemoteException;
	void updateSetsPlayers(String playerName, String raceList, String abilityList) throws RemoteException;

	void updateCoinCost(ArrayList<Integer> gains) throws RemoteException;

	void updateSetList(String playerName, String race, String ability) throws RemoteException;

}
