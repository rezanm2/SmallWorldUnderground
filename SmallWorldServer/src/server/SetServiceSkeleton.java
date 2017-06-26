package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SetServiceSkeleton  extends Remote{


	void addSetClient(SetServiceClientSkeleton setClient) throws RemoteException;

	void updateSetList(String race, String ability) throws RemoteException;
	void updateDeclineset(String playerName, String race, String ability) throws RemoteException;
	
	void giveAllInformationPlayer(String playerName, int handTokens, int declineTokens, int balance) throws RemoteException;
	void updateSetsPlayers(String playerName, String raceList, String abilityList) throws RemoteException;

	void updateSetList(String playerName, String race, String ability) throws RemoteException;

}
