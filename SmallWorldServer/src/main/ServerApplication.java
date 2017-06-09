package main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.ClientSkeleton;
import views.ServerController;

public class ServerApplication  extends Application{

	private static boolean isRunning = false;
	private static boolean onFirstStart = true;
	private static Registry registry;
	private static ServerImpl serverImpl;
	private static int portNumber = 1099;
	private static ClientSkeleton [] Clients;
	private static int i = 0;
	private static int amountPlayers;
	private static RemoteServer server;


	public static void main(String[] args) throws RemoteException, MalformedURLException {
		server = new RemoteServer();
		launch(args);														// starts the javafx application
	}


	public static void stopServer() {
		try {
			registry.unbind("server");								//unbinds the serverobject
			System.out.println("Shutting down");
			UnicastRemoteObject.unexportObject(serverImpl, true);	//unexports the object from the server
			isRunning = false;										// sets isRunning false so the server is off
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Server is al uit");
		} catch (NullPointerException e) {
			System.out.println("Server is al uit");
		}
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Server.fxml"));	//get xml file
		Parent View  = loader.load();														//load xml file to object
		ServerController controller = loader.getController();								//get controller
		controller.setServer(server);														//give controller refrence to the server

       // Parent View = FXMLLoader.load(getClass().getResource("../views/Server.fxml")); 	// connects with the view
        Scene scene = new Scene(View);											// sets view
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> stopServer());						// on close the server shutsdown



	}

	public static String getHostIP() {											// this method gets the serverIP
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    return address.getHostAddress();
	}

	public static ClientSkeleton getClient(int pos) {							// returns a client
		return Clients[pos];
	}

	public static String getClientUsername(int pos) throws RemoteException {	// returns a clients username
		return Clients[pos].getUsername();
	}

}
