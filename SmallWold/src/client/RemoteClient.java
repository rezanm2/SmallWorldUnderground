package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.ServerSkeleton;

public class RemoteClient extends UnicastRemoteObject {


	private static final long serialVersionUID = 1L;
	private ServerSkeleton server = null;
	private String host = "127.0.0.1";
	private ClientImpl clientImpl;

	protected RemoteClient() throws RemoteException {
		super();
		System.out.println("Client: server listener  starting up...");
		try {
			System.out.println("Client: looking up Server in RMI Registry...");
			server = (ServerSkeleton) Naming.lookup("//" + host + "/ServerService");
			this.clientImpl = new ClientImpl();
		} catch (NotBoundException nbe){
			System.out.println(nbe);
		} catch (MalformedURLException mfue){
			System.out.println(mfue);
		}


	}

	public void register() throws RemoteException{

		System.out.println("testing join");
		server.addClient(this.clientImpl);
		//server.echo("EHUHEUHUEUHE");

		//server.registerObserver(this);
	}

}
