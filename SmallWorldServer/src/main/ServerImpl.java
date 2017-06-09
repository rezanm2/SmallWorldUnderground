package main;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;

import server.ClientSkeleton;
import server.ServerSkeleton;

public class ServerImpl extends UnicastRemoteObject implements ServerSkeleton{


	private static final long serialVersionUID = 1L;
	int amountPlayersATM = 0;
	private RemoteServer server;


	protected ServerImpl(RemoteServer remoteServer) throws RemoteException {
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
	public void addClient(ClientSkeleton client) throws RemoteException {
		server.addClient(client);
	}

}
