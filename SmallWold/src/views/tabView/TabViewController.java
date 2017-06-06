package views.tabView;

//import application.Start;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
//import model.tabModel;

public class TabViewController {
	@FXML
    private StackPane mainPane;

	@FXML
    private Label player_1;


	public TabViewController(){
	}


    public void showView(){
    	mainPane.setVisible(true); //activate on TAB key pressed - called in FieldViewController
    }

    public void hideView(){
    	mainPane.setVisible(false); //activate on TAB key release - called in FieldViewController
    }

    public boolean isVisible(){
    	return mainPane.visibleProperty().get();
    }
/*
    public void setMainApp(Start app){


    	for (tabModel model : app.getModel()) {
    		player_1.setText(model.getPlayerName());

		}
    }

*/

}
