package client;

import java.io.IOException;
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
import rmi.TurnService;
import server.ClientSkeleton;
import server.ServerSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;

public class RemoteClient {

	private ServerSkeleton server = null;
	private TurnServiceSkeleton serverTurnService;
	private String host = "127.0.0.1";
	private ClientImpl clientImpl;
	private ObservableList<JoinedPlayers> players = FXCollections.observableArrayList();
	private ClientApplication app;
	private TurnService turnClient;

	protected RemoteClient(ClientApplication app) throws RemoteException {
		this.app = app;
		this.clientImpl = new ClientImpl(this);
		players.addAll(new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"),
				new JoinedPlayers("-")); // make list of joinable places

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

		Platform.runLater(() -> {
			int i = 0;
			for (String player : playerList) {
				players.get(i).setPlayerName(player);
				i++;
			}
		});
	}
	public void startGame(int playerAmount) throws IOException{
		Platform.runLater(() -> {
			try {
				app.StartGameScreen(playerAmount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public void setTurnService() {


		try {

			System.out.println("Client: looking up turnServiceServer in RMI Registry...");
			serverTurnService = (TurnServiceSkeleton) Naming.lookup("//" + host + "/ServerTurnService");
			turnClient = new TurnService();
			serverTurnService.addTurnClient(turnClient);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
