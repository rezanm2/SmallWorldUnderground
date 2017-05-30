package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientSkeleton extends Remote{

	public String getUsername() throws RemoteException;
	public String getHostIP() throws RemoteException;
	
}
