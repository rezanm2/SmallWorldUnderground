package views.tabView;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import application.Start;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import main.Main;
//import model.tabModel;
import player.Player;

public class TabViewController {
	@FXML
    private StackPane mainPane;

	@FXML
    private Label player_1;
	@FXML
    private Label player_2;
	@FXML
    private Label player_3;
	@FXML
    private Label player_4;

	private ObservableList<Player> playerData = FXCollections.observableArrayList();;

    private ObservableList<Label> playerLabelList = FXCollections.observableArrayList();

//Constructor
	  @FXML
	    private void initialize() {
		  addLabelsToList();
	    }

    public void showView(){
    	mainPane.setVisible(true); //activate on TAB key pressed - called in FieldViewController
    }

    public void hideView(){
    	mainPane.setVisible(false); //activate on TAB key release - called in FieldViewController
    	playerData.get(0).setName("hans");
    }

    public boolean isVisible(){
    	return mainPane.visibleProperty().get();
    }

 /*   public void setPlayers(String selfName, List<Player> playerList){
    	int i = 0;
    	for (Player player : playerList) {
    		if(!player.getName().equals(selfName)){
    			playerLabelList.get(i).setText(player.getName());
    			i++;
    		}
		}

    }*/

    public void addLabelsToList(){
    	playerLabelList.addAll(player_1, player_2,player_3, player_4);
    }


    public void setMainApp(Main app){

    //	playerData = app.getList();
    	playerData.add(new Player("test"));


    	player_1.textProperty().bind(playerData.get(0).getName());
    }



}
