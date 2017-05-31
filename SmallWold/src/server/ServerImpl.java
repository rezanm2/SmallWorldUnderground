package server;

import java.rmi.RemoteException;

import client.ClientSkeleton;

public class ServerImpl implements ServerSkeleton{
	
	int i = 0;
	int amountPlayersATM = 0;
	
	@Override
	public synchronized void addClient(String ip) throws RemoteException {
		ServerMain.addClient(ip);
		System.out.println("Player: " + ServerMain.getClient(amountPlayersATM).getUsername() + " joined at " + ServerMain.getClient(amountPlayersATM).getHostIP());
		System.out.println(ServerMain.getClientUsername(amountPlayersATM));
		System.out.println(i + " " + amountPlayersATM);
		i++;
		amountPlayersATM++;
		System.out.println(i + " " + amountPlayersATM);
	}

	@Override
	public String giveUsername(int j) throws RemoteException {
		return ServerMain.getClient(j).getUsername();
	}

	@Override
	public int getamountPlayers() {
		return amountPlayersATM;
	}

}
