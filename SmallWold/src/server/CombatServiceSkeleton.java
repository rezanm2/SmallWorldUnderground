package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */

public interface CombatServiceSkeleton extends Remote{

	void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException;


	void addCombatClient(CombatServiceClientSkeleton combatClient) throws RemoteException;


	void updateLosePlayer(String name, int losingTokens) throws RemoteException;

}
