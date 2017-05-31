package server;

import java.rmi.RemoteException;

import client.ClientSkeleton;

public class ServerImpl implements ServerSkeleton{
	
	int i = 0;
	
	@Override
	public synchronized void addClient(String ip) throws RemoteException {
		ServerMain.addClient(ip);
		System.out.println("Player: " + ServerMain.getClient(i).getUsername() + " joined at " + ServerMain.getClient(i).getHostIP());
		i++;
	}

	@Override
	public String giveUsername(int j) throws RemoteException {
		return ServerMain.getClient(j).getUsername();
	}

}
