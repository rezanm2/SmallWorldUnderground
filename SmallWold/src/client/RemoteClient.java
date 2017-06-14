package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.JoinedPlayers;
import server.ClientSkeleton;
import server.ServerSkeleton;

public class RemoteClient {

	private ServerSkeleton server = null;
	private String host = "127.0.0.1";
	private ClientImpl clientImpl;
	private ObservableList<JoinedPlayers> players = FXCollections.observableArrayList();

	protected RemoteClient() throws RemoteException {
		this.clientImpl = new ClientImpl(this);
		players.addAll(new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"),
				new JoinedPlayers("-"));

	}

	public void loadServer() throws RemoteException {
		System.out.println("Client: server listener  starting up...");
		try {
			System.out.println("Client: looking up Server in RMI Registry...");
			server = (ServerSkeleton) Naming.lookup("//" + host + "/ServerService");
		} catch (NotBoundException nbe) {
			System.out.println(nbe);
		} catch (MalformedURLException mfue) {
			System.out.println(mfue);
		}
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setImplName(String username) {
		clientImpl.setUsername(username);
	}

	public void register() throws RemoteException {

		System.out.println("testing join");
		server.addClient(clientImpl);
	}

	public ObservableList<JoinedPlayers> getPlayers() {
		return players;
	}

	public void updatePlayerList(ArrayList<String> playerList) {

		System.out.println("reached0");
		Platform.runLater(() -> {
			try {
				test(playerList);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

	public void test(ArrayList<String> playerList) throws RemoteException {
		int i = 0;
		for (String player : playerList) {
			players.get(i).setPlayerName(player);
			i++;
		}

	}

}
