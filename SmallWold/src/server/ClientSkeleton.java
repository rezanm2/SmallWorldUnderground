package server;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientSkeleton extends Remote{

	public String getUsername() throws RemoteException;
	public String getHostIP() throws RemoteException;
	public void startGame() throws RemoteException, IOException;
	public void notifyMessage(String message)throws RemoteException;
	public void updatePlayerList(ArrayList<String> playerList)throws RemoteException;
	public void updatePlayerTurn(String player)throws RemoteException;
	public void StartTurn() throws RemoteException;
	public void notifyOfStart(int playerAmount) throws RemoteException, IOException;
}
