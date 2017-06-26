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

	void updateSetList(String race, String ability) throws RemoteException;

	void updateCoinCost(ArrayList<Integer> gains) throws RemoteException;


}
