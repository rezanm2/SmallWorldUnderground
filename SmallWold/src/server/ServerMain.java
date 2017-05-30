package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

import client.ClientImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerMain extends Application{

	private static boolean aan = false;
	private static boolean onFirstStart = true;
	private static Registry registry;
	private static ServerImpl serverImpl;
	private static int portNumber = 1099;
	private static ClientImpl [] Clienten = new ClientImpl[5];
	private static int i = 0;
	
	public static void main(String[] args) {
		//ServerMain.startServer();
		launch();
	}
	
	public static void startServer() {		
		try {
			if(onFirstStart == true) {
				registry = LocateRegistry.createRegistry(portNumber);
				onFirstStart = false;
			}
			if(aan == true)
			{
				System.out.println("Server already running");
			}
			else
			{
			
				aan = true;
				serverImpl = new ServerImpl();
				ServerSkeleton serverSkeleton = (ServerSkeleton) UnicastRemoteObject.exportObject(serverImpl, 0);
				registry.rebind("server", serverSkeleton);
				System.out.println("Server is running");
			}
				} catch (ExportException e) {
					System.out.println("Server already running");
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			//registry = LocateRegistry.getRegistry(portNumber);
			
			
	}
	
	public static void stopServer() {
		try {
			registry.unbind("server");
			System.out.println("Shutting down");
			UnicastRemoteObject.unexportObject(serverImpl, true);
			aan = false;
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
	
	public static void addClient(String ip) {
		try {
			Registry registry = LocateRegistry.getRegistry(ip, 1098);
			Clienten[i] = (ClientImpl) registry.lookup("client");
			i++;
			} catch (ArrayIndexOutOfBoundsException AIB) {
				System.out.println("Server is vol");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
        Parent View = FXMLLoader.load(getClass().getResource("Server.fxml")); 
        Scene scene = new Scene(View);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> stopServer());
	}
	
	public static String getHostIP() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} 
	    return address.getHostAddress();
	}

}
