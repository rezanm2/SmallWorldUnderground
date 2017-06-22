package server;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface CombatServiceSkeleton extends Remote{

	void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException;


	void addCombatClient(CombatServiceClientSkeleton combatClient) throws RemoteException;

}
