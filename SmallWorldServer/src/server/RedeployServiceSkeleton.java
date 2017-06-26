package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RedeployServiceSkeleton extends Remote{

	void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException;


	void addRedeployClient(RedeployServiceClientSkeleton redeployClient) throws RemoteException;


}
