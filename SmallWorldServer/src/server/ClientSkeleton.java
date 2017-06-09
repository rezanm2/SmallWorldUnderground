package server;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientSkeleton extends Remote{

	public String getUsername() throws RemoteException;
	public String getHostIP() throws RemoteException;
	public void startGame() throws RemoteException, IOException;
	public void notifyMessage(String message)throws RemoteException;
}
