package client;

public class ClientImpl implements ClientSkeleton{
	
	private String hostIP;
	private String username;
	
	public ClientImpl(String hostIP, String username) {
		this.hostIP = hostIP;
		this.username = username;
	}
	
	@Override
	public String getUsername(){
		return username;
	}
	
	@Override
	public String getHostIP(){
		return hostIP;
	}

}
