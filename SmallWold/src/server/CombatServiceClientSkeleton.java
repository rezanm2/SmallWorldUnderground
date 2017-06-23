package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
public interface CombatServiceClientSkeleton extends Remote{

	void syncTerrain(ServerTerrain terrain) throws RemoteException;

	void syncLoses(String name, int losingTokens) throws RemoteException;

}
