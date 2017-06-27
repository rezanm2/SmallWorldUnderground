package client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controllers.CombatController;
import controllers.RedeploymentController;
import controllers.TurnController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.JoinedPlayers;
import models.StackSet;
import playBoard.Map;
import player.Player;
import rmi.ClientImpl;
import rmi.CombatService;
import rmi.RedeploymentService;
import rmi.SetService;
import rmi.TurnService;
import server.ClientSkeleton;
import server.CombatServiceSkeleton;
import server.RedeployServiceSkeleton;
import server.ServerSkeleton;
import server.SetServiceClientSkeleton;
import server.SetServiceSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;
import views.fieldView.FieldViewController;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;
/**
 * Deze class is wat de client online zet voor de server maar vooral ook wat deze van de server krijgt.
 *
 * @author Wim van der Putten
 *
 */
public class RemoteClient {

	private ServerSkeleton server = null;
	private String host = "127.0.0.1";
	private ClientImpl clientImpl;
	private ObservableList<JoinedPlayers> players = FXCollections.observableArrayList();
	private ClientApplication app;

	/**
	 * Deze constructor neemt eerst de clientApplication over die hij daarvan heeft meegekregen en maakt vervolgens een clientImplementatie.
	 * Daarna worden de labels in de clientlobby op "-" gezet.
	 *
	 * @param app, de clientApplication die de remoteClient aanmaakt
	 * @throws RemoteException
	 */

	protected RemoteClient(ClientApplication app) throws RemoteException {
		this.app = app;
		this.clientImpl = new ClientImpl(this);
		players.addAll(new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"), new JoinedPlayers("-"),new JoinedPlayers("-")); // make list of joinable places

	}

	/**
	 * Client zoekt met deze methode de serverhost op en probeert vervolgens een object hiervan binnen te laden.
	 *
	 * @throws RemoteException
	 */

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

	/**
	 * Zet de username van de speler en zorgt dat deze ook te zien is.
	 *
	 * @param username
	 */
	public void setImplName(String username) {
		app.getPlayer().setName(username);
		clientImpl.setUsername(username);
		System.out.println(username);
	}

	/**
	 * Met deze functie registreert de client zich bij de server.
	 *
	 * @throws RemoteException
	 */
	public void register() throws RemoteException {

		System.out.println("joining..");
		server.addClient(clientImpl);
	}

	public ObservableList<JoinedPlayers> getPlayers() {
		return players;
	}
	/**
	 * Deze functie update de playerlist zodat er gezien kan worden in de lobby wie er gejoind zijn.
	 *
	 * @param playerList
	 */
	public void updatePlayerList(ArrayList<String> playerList) {

		Platform.runLater(() -> {
			int i = 0;
			for (String player : playerList) {
				players.get(i).setPlayerName(player);
				i++;
			}
		});
	}
	/**
	 * Deze methode start het spel en zet de RMIservice's aan.
	 *
	 * @param playerAmount, het aantal spelers wat meedoet aan het spel.
	 * @throws IOException
	 */

	public void startGame(int playerAmount) throws IOException{
		Platform.runLater(() -> {
			try {
				app.StartGameScreen(playerAmount, players);

				setRMIService(app.getTabController(), app.getSidebarController(),app.getFieldController(), app.getPlayer(), playerAmount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	/**
	 * Deze methode zorgt ervoor dat de client de services kan krijgen van de server.
	 * De client ontvangt en maakt een setService, een combatService en een turnService aan.
	 *
	 * @param tabController, de controller van de tabView in het spel.
	 * @param sideBarController, de controller van de sideBarView in het spel.
	 * @param fieldViewController, de controller van de fieldView in het spel.
	 * @param selfPlayer, de speler zelf.
	 * @param playerAmount, het aantal spelers wat meedoet aan het spel.
	 */

	public void setRMIService(TabViewController tabController, SideBarController sideBarController, FieldViewController fieldViewController, Player selfPlayer, int playerAmount) {


		try {

			//start setup for set service
			System.out.println("Client: looking up ServerSetService in RMI Registry...");
			SetServiceSkeleton serverSetService = (SetServiceSkeleton) Naming.lookup("//" + host + "/ServerSetService");

			StackSet stack = new StackSet(tabController, selfPlayer, serverSetService);

			SetService setClient = new SetService(stack);
			serverSetService.addSetClient(setClient);


			//start setup for CombatService
			System.out.println("Client: looking up combatServiceServer in RMI Registry...");
			CombatServiceSkeleton serverCombatService = (CombatServiceSkeleton) Naming.lookup("//" + host + "/ServerCombatService");

			Map map  = new Map(selfPlayer, playerAmount, stack);
			CombatController combatController = new CombatController(fieldViewController, serverCombatService, map);

			CombatService combatClient = new CombatService(combatController);
			serverCombatService.addCombatClient(combatClient);



			//start setup for RedeploymentService
			System.out.println("Client: looking up RedeploymentService in RMI Registry...");
			//RedeployServiceSkeleton serverRedeployService = (RedeployServiceSkeleton) Naming.lookup("//" + host + "/ServerRedeploymentService");

			//RedeploymentController redeployController = new RedeploymentController(fieldViewController, serverRedeployService, map);

			//RedeploymentService redeployClient = new RedeploymentService(redeployController);
			//serverRedeployService.addRedeployClient(redeployClient);



			//start setup for Turn service
			System.out.println("Client: looking up turnServiceServer in RMI Registry...");
			TurnServiceSkeleton serverTurnService = (TurnServiceSkeleton) Naming.lookup("//" + host + "/ServerTurnService");

			TurnController turnController = new TurnController(map, sideBarController, serverTurnService);

			TurnService turnClient = new TurnService(selfPlayer, sideBarController);
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
