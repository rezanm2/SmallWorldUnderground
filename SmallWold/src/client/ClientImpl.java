package client;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.ClientSkeleton;

public class ClientImpl extends UnicastRemoteObject implements ClientSkeleton{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String hostIP;
	private String username;

	public ClientImpl() throws RemoteException{
		//this.hostIP = hostIP;
		//this.username = username;
	}

	@Override
	public String getUsername(){
		return username;
	}

	@Override
	public String getHostIP(){
		return hostIP;
	}

	@Override
	public void startGame() throws RemoteException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyMessage(String string) {
	System.out.println(string);

	}

}
