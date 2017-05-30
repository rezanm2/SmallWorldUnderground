package server;

import java.time.Instant;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ServerController {
	
	private String HostIP;
	
	@FXML private Label HostIPadres;
	@FXML private TextArea ServerLog;
 
	@FXML
	private void setIP() {
		HostIP = ServerMain.getHostIP();
		HostIPadres.setText("Server IP: " + HostIP);
	}
	
	@FXML
	private void logging(String logtekst) {
		ServerLog.appendText(" <" + Instant.now() + "> " + logtekst + "\n");
	}
	
	public void startServer() {
		ServerMain.startServer();
		setIP();
		logging("Server started");
	}
	
	public void stopServer() {
		ServerMain.stopServer();
		logging("Server stopped");
	}
	
}
