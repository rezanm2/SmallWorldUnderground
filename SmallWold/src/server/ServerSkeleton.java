package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ClientSkeleton;

public interface ServerSkeleton extends Remote{
	
	public void addClient(String ip) throws RemoteException;
	
	public String giveUsername(int pos) throws RemoteException;

}
