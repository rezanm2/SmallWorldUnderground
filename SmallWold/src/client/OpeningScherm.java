package client;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OpeningScherm extends Stage{
	TextField tf;
	TextField ip;
	Button start;
	
	public OpeningScherm() {
		BorderPane bp = new BorderPane();
		tf = new TextField();
		ip = new TextField();
		start = new Button("");
		
		bp.setTop(start);
		bp.setCenter(tf);
		bp.setBottom(ip);
		
		Scene scene = new Scene(bp, 600, 600);
		setScene(scene);
		show();
	}

}
