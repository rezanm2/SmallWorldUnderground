package client;

import javafx.application.Application;
import javafx.stage.Stage;
import server.Beeld;

public class Client extends Application{
	
	public static void main(String[] args){
		launch();
}
	@Override
	public void start(Stage primaryStage) throws Exception {	
		//new OpeningScherm();
		
		new Beeld();
	}
}
