package server;

import java.time.Instant;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ServerController {
	
	private String HostIP;
	
	@FXML private Label HostIPadres;
	@FXML private TextArea ServerLog;
	
	public void initialize() {
		HostIP = ServerMain.getHostIP();
		HostIPadres.setText("Server IP: " + HostIP);
	}
	
	public void logging(String logtekst) {
		ServerLog.appendText(" <" + Instant.now() + "> " + logtekst + "\n");
	}
	
	public void startServer() {
		ServerMain.startServer();
		logging("Server started at " + HostIP);
	}
	
	public void stopServer() {
		ServerMain.stopServer();
		logging("Server stopped");
	}
	
}
