package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.JoinedPlayers;
import server.ClientSkeleton;
import server.ServerSkeleton;

public class RemoteClient extends UnicastRemoteObject {


	private static final long serialVersionUID = 1L;
	private ServerSkeleton server = null;
	private String host = "127.0.0.1";
	private ClientImpl clientImpl;
    private ObservableList<JoinedPlayers> players = FXCollections.observableArrayList();


	protected RemoteClient() throws RemoteException  {
		this.clientImpl = new ClientImpl();
		players.addAll(new JoinedPlayers("-"),new JoinedPlayers("-"),new JoinedPlayers("-"),new JoinedPlayers("-"),new JoinedPlayers("-"));

	}

	public void loadServer() throws RemoteException{
		System.out.println("Client: server listener  starting up...");
		try {
			System.out.println("Client: looking up Server in RMI Registry...");
			server = (ServerSkeleton) Naming.lookup("//" + "127.0.0.1" + "/ServerService");
			System.out.println(server);
		} catch (NotBoundException nbe){
			System.out.println(nbe);
		} catch (MalformedURLException mfue){
			System.out.println(mfue);
		}
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setImplName(String username){
		clientImpl.setUsername(username);
	}

	public void register() throws RemoteException{

		System.out.println("testing join");
		server.echo("asdasdas");
		server.addClient(clientImpl);
	}
	public ObservableList<JoinedPlayers> getPlayers() {
		return players;
	}

	public void updatePlayerList(ArrayList<ClientSkeleton> clientList) throws RemoteException {
		int i=0;
		for (ClientSkeleton client : clientList) {
			players.get(i).setPlayerName(client.getUsername());
			i++;
		}
	}

}
