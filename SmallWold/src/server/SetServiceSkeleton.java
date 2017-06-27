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

	void updateSetList(String playerName, String race, String ability) throws RemoteException;

	void giveAllInformationPlayer(String name, int currentTokens, int declineTokens, int coins) throws RemoteException;

	void updateDeclineset(String name, String name2, String name3)throws RemoteException;

	void updateCoinCost(ArrayList<Integer> gains) throws RemoteException;


}
