package server;

import java.rmi.RemoteException;

public class ServerImpl implements ServerSkeleton{
	
	int i = 0;
	
	@Override
	public synchronized void addClient(String ip) throws RemoteException {
		ServerMain.addClient(ip);
		System.out.println(ServerMain.getClient(i).getUsername());
		i++;
	}

}
