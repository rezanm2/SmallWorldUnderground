package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RedeployServiceClientSkeleton extends Remote{

	void syncTerrain(ServerTerrain terrain) throws RemoteException;

}
