package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.util.ArrayList;

import data.Player;
import rmi.CombatService;
import rmi.ServerImpl;
import rmi.SetService;
import rmi.TurnService;
import server.ClientSkeleton;

public class RemoteServer {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int amountPlayers;
	private boolean onFirstStart;
	private int port;
	private boolean isRunning;
	private ServerImpl serverImpl;
	private TurnService turnService;
	private ArrayList<ClientSkeleton> clientList = new ArrayList<ClientSkeleton>();
	private ArrayList<String> playerNameList = new ArrayList<String>();
	private ArrayList<Player> playerList = new ArrayList<Player>();

	protected RemoteServer() throws RemoteException {
		this.port = 1099;
		isRunning = false;
		onFirstStart = true;
		// super(1099); // Port where RMI Registry listens

	}

	public void startServer(int amount) throws MalformedURLException { // server
																		// requirs
																		// a
																		// amount
																		// of
																		// players
		this.amountPlayers = amount;
		try {

			if (onFirstStart == true) { // if on first start
				LocateRegistry.createRegistry(port); // creates a registery at
														// the portnumber (1099)
				System.out.println("Server: connected to RMI registry.");
				onFirstStart = false; // sets the firststart on false
			}
			if (isRunning == true) // if the server is on
			{
				System.out.println("Server already running");
			} else {
				System.out.println("Amount of players: " + amountPlayers);
				isRunning = true; // sets isRunning to true
				serverImpl = new ServerImpl(this); // creates a
													// serverimplementation

				Naming.rebind("ServerService", serverImpl);

				System.out.println("Server: server registered as \'ServerService\' in RMI registry.");
				System.out.println("Server is running");
			}
		} catch (ExportException e) {
			System.out.println("Server already running");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public synchronized void addClient(ClientSkeleton client) throws InterruptedException, IOException {
		if (this.clientList.size() < amountPlayers) {
			System.out.println("Server: adding Client");
			this.clientList.add(client);
			System.out.println("Server: Client added");
			client.notifyMessage("Server: Server joined!!");

			sendPlayerList(client);
			Thread.sleep(20);
				if (this.clientList.size() == amountPlayers) { //last player joined made the lobby full
					startRMIService();
				}


		} else {
			System.out.println("SERVER IS FULL");
			client.notifyMessage("Failed joining: server is full");

		}
	}


	public void sendPlayerList(ClientSkeleton addedClient) throws RemoteException {

		new Thread(() -> {
			try {
				String name  = addedClient.getUsername();

				if(name.equalsIgnoreCase("player")){
					name = ("player_"+(playerList.size()+1));
				}


				playerList.add(new Player(name));		//add player to the player list, contains all var's of the player
				playerNameList.add(name);				//add players name to list that gets send to all players

				for (ClientSkeleton client : clientList) {
					client.updatePlayerList(playerNameList);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}).start();

	}

	public void startRMIService() throws InterruptedException, IOException {


			turnService = new TurnService(playerList);
			Naming.rebind("ServerTurnService", turnService);
			System.out.println("Server: turnService registered as \'ServerTurnService\' in RMI registry.");

			SetService setService = new SetService(playerList);
			Naming.rebind("ServerSetService", setService);
			System.out.println("Server: SetService registered as \'ServerSetService\' in RMI registry.");

			CombatService combatService = new CombatService(playerList);
			Naming.rebind("ServerCombatService", combatService);
			System.out.println("Server: SetService registered as \'ServerCombatService\' in RMI registry.");

			notifyClientOfStart();


	}

	public void notifyClientOfStart() throws InterruptedException, RemoteException, IOException{
		new Thread(() -> {
			try {


				Thread.sleep(5);

			for (ClientSkeleton client : clientList) {
				client.notifyOfStart(amountPlayers);
			}


			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}).start();

	}
}
