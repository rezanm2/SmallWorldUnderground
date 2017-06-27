package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TurnServiceClientSkeleton  extends Remote{

	public void updatePlayerTurn(String string) throws RemoteException;

	public void StartTurn(int turn) throws RemoteException;
	String getName() throws RemoteException;


}