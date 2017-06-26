package rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.RemoteClient;
import server.ClientSkeleton;
/**
 * Dit is de implementatie van de client.
 *
 * @author Wim van der Putten
 *
 */
public class ClientImpl extends UnicastRemoteObject implements ClientSkeleton{


	private static final long serialVersionUID = 1L;
	private String hostIP;
	private String username;
	private RemoteClient remoteClient;

	/**
	 * Maakt een clientImplementatie aan en gebruikt hiervoor een remoteClient, vervolgens wordt deze remoteClient in de class vastgezet.
	 *
	 * @param remoteClient, de remoteClient van de client zelf.
	 * @throws RemoteException
	 */
	public ClientImpl(RemoteClient remoteClient) throws RemoteException{
		this.remoteClient = remoteClient;
	}

	public void setUsername(String username) {
		this.username = username;
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

	}

	@Override
	public void notifyMessage(String string) {
	System.out.println(string);

	}

	@Override
	public void updatePlayerList(ArrayList<String> playerList) throws RemoteException {
		remoteClient.updatePlayerList(playerList);

	}


	@Override
	public void updatePlayerTurn(String player) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void StartTurn() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyOfStart(int playerAmount) throws RemoteException, IOException {
	remoteClient.startGame(playerAmount);
	//remoteClient.setTurnService();

	}

}
