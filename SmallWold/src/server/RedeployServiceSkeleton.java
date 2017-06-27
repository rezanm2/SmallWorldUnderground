package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import races.Race;

public interface RedeployServiceSkeleton extends Remote{

	void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException;


	void addRedeployClient(RedeployServiceClientSkeleton redeployClient) throws RemoteException;


	void syncTerrains(ArrayList<String> updateList) throws RemoteException;


	void deployTerrain(String terrainId, int declaredTokenAmount) throws RemoteException;


}
