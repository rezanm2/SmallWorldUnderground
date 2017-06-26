package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.SetService;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
public interface SetServiceClientSkeleton  extends Remote{

	void updateStackList(ArrayList<String> raceList, ArrayList<String> abilityList) throws RemoteException;


}
