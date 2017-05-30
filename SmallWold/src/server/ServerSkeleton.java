package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerSkeleton extends Remote{
	
	public void addClient(String ip) throws RemoteException;

}
