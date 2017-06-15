package views.tabView;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import models.JoinedPlayers;
import models.Set;


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

	@FXML
    private ImageView pick_race_1;

	@FXML
    private ImageView pick_race_2;

	@FXML
    private ImageView pick_race_3;

	@FXML
    private ImageView pick_race_4;

	@FXML
    private ImageView pick_race_5;

	@FXML
    private ImageView pick_race_6;

	public TabViewController(){

	}
	public void onclick(){
System.out.println("im not broken!!");
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
	public void setStack(ObservableList<Set> sets) {
		//    	tabImage.setImage(new Image("/images/icons/tab-bar-stripes-pressed.png"));
		//player5.textProperty().bind(playerList.get(4).getPlayerNameProperty());
		System.out.println(sets.size());

		System.out.println(sets.get(0).getRace());
		System.out.println(sets.get(1).getRace());
		System.out.println(sets.get(2).getRace());
		System.out.println(sets.get(3).getRace());
		System.out.println(sets.get(4).getRace());
		System.out.println(sets.get(5).getRace());
		pick_race_1.setImage(new Image("/images/races/active/"+sets.get(0).getRace().getName()+".png"));
		pick_race_2.setImage(new Image("/images/races/active/"+sets.get(1).getRace().getName()+".png"));
		pick_race_3.setImage(new Image("/images/races/active/"+sets.get(2).getRace().getName()+".png"));
		pick_race_4.setImage(new Image("/images/races/active/"+sets.get(3).getRace().getName()+".png"));
		pick_race_5.setImage(new Image("/images/races/active/"+sets.get(4).getRace().getName()+".png"));
		pick_race_6.setImage(new Image("/images/races/active/"+sets.get(5).getRace().getName()+".png"));

	}





}
