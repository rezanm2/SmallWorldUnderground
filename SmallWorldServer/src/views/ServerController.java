package views;


import java.time.Instant;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.RemoteServer;
import main.ServerApplication;
import save.Save;

public class ServerController {

	private String hostIP;
	private boolean isRunning = false;
	private RemoteServer server;
	private Save save = new Save();

	@FXML private Label hostIPadres;
	@FXML private TextArea serverLog;
	@FXML private ChoiceBox<String> choicebox;
	@FXML private Button serverButton;

	public void initialize() {
		hostIP = ServerApplication.getHostIP();							//Get server IP from the mainclass of the server
		hostIPadres.setText("Server IP: " + hostIP);				//Set the server IP on the serverview
	    choicebox.getItems().addAll("2 Spelers", "3 Spelers", "4 Spelers", "5 Spelers"); //set options for the choicebox on the serverview
	    choicebox.getSelectionModel().select(0);					//Set the standard option for the choicebox on 2 players
	}
	public void setServer(RemoteServer server){
		this.server = server;
	}
	public void save()
	{
		save.SaveNames(server.getListPlayers(),server.getMap());
	}
	public void logging(String logtekst) {
		serverLog.appendText(" <" + Instant.now() + "> " + logtekst + "\n"); 	//Log the startup and shutdown of the server
	}
	public void echo(){
System.out.println("SAJDHJASJDASD");
	}

	public void configureServer() throws Exception {
		if(isRunning  == false) { 							// checks if the server is
			server.startServer(Character.getNumericValue(choicebox.getSelectionModel().getSelectedItem().toString().charAt(0)));
			// gets the number of players and converts it to a single number and starts the server
			isRunning = true; 								// sets the server on running mode / server is on
			serverButton.setText("Stop server");			// changes text on the button
			logging("Server started at " + hostIP);			// prints log on screen
		}
		else {
			ServerApplication.stopServer();						// stops the server
			isRunning = false;								// sets the server off
			serverButton.setText("Start server");			// changes text on the button
			logging("Server stopped");						// prints log on screen
		}


	}

}
