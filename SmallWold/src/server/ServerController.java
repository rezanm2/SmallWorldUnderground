package server;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ServerController {
	
	private String HostIP;
	
	@FXML
	private Label HostIPadres;
	private Label ServerLog;

	@FXML
	private void setIP() {
		HostIP = ServerMain.getHostIP();
		HostIPadres.setText("Server IP: " + HostIP);
		logging();
	}
	
	@FXML
	private void logging() {
		ServerLog.setText("test");
	}
	
	public void startServer() {
		ServerMain.startServer();
		setIP();
		
	}
	
	public void printbs() {
		System.out.println("wftwtf");
	}
	
	public void stopServer() {
		ServerMain.stopServer();
	}
	
}
