package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerSkeleton extends Remote{

	//public void addClient() throws RemoteException, IOException;
    public void addClient(ClientSkeleton client) throws RemoteException;

	public String giveUsername(int pos) throws RemoteException;

	public int getamountPlayers() throws RemoteException;

	public void echo(String message) throws RemoteException;

}
