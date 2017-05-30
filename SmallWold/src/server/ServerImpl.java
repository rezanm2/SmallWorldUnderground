package server;

public class ServerImpl implements ServerSkeleton{
	
	@Override
	public void addClient(String ip) {
		ServerMain.addClient(ip);
	}

}
