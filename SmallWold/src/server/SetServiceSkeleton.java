package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SetServiceSkeleton  extends Remote{


	void addSetClient(SetServiceClientSkeleton setClient) throws RemoteException;

	void updateSetList(String race, String ability) throws RemoteException;


}
