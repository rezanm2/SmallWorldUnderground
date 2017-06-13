package client;

import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.JoinedPlayers;
import views.lobbyView.lobbyController;

public class ClientApplication extends Application{

	private static RemoteClient client;



	public ClientApplication() {
	//	remoteObject = new RemoteClient();
	}


	public static void main(String[] args) throws RemoteException {
		client = new RemoteClient();

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader lobbyLoader = new FXMLLoader(getClass().getResource("../views/lobbyView/lobbyView.fxml"));	//get xml file
		Parent View  = lobbyLoader.load();																		//load the xml in view
		lobbyController lobbyControl = lobbyLoader.getController();												//get ref to controller
		lobbyControl.setRemoteClient(client);																	//give the controller a ref to the client object
		lobbyControl.initLabel();


		Scene scene = new Scene(View);
		primaryStage.setScene(scene);
		primaryStage.show();
		//primaryStage.setOnCloseRequest(e -> stopClientserver());
	}



}
