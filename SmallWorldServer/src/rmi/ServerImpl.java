package rmi;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import main.RemoteServer;
import main.ServerApplication;
import server.ClientSkeleton;
import server.ServerSkeleton;

public class ServerImpl extends UnicastRemoteObject implements ServerSkeleton{


	private static final long serialVersionUID = 1L;
	int amountPlayersATM = 0;
	private RemoteServer server;


	public ServerImpl(RemoteServer remoteServer) throws RemoteException {
		super();
		this.server = remoteServer;

	}



	@Override
	public String giveUsername(int j) throws RemoteException {
		return ServerApplication.getClient(j).getUsername();
	}

	@Override
	public int getamountPlayers() {
		return amountPlayersATM;
	}

	@Override
	public void echo(String message) throws RemoteException {
		System.out.println(message);

	}



	@Override
	public void addClient(ClientSkeleton client) throws InterruptedException, IOException {
		server.addClient(client);
	}

}
