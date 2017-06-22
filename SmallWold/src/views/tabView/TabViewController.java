package views.tabView;


import java.rmi.RemoteException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import models.JoinedPlayers;
import models.Set;
import models.StackSet;
import player.Player;

import views.bottomBarView.BottomBarController;

public class TabViewController {

	private StackSet stackset;
	private Player selfPlayer;


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

	@FXML
    private ImageView pick_ability_1;

	@FXML
    private ImageView pick_ability_2;

	@FXML
    private ImageView pick_ability_3;

	@FXML
    private ImageView pick_ability_4;

	@FXML
    private ImageView pick_ability_5;

	@FXML
    private ImageView pick_ability_6;

	@FXML
    private ImageView ac_ab_1;

	@FXML
    private ImageView ac_rc_1;
	private BottomBarController bottomBarController;



	public TabViewController(){

	}

	public void pickSet(MouseEvent ev) throws RemoteException
	{
			if(this.selfPlayer.isMyTurn()){
			ImageView test = (ImageView) ev.getTarget();
			System.out.println(test.getId());
			char [] iets = test.getId().toCharArray();
			//Character.isDigit(iets[iets.length-1]);
			int choice = Character.getNumericValue(iets[iets.length-1]);
			System.out.println(choice);
			stackset.getStackController().chooseSet(choice-1);
			}
	}

	public void onclick(){
	}


    public void showView(){
    	mainPane.setVisible(true); //activate on TAB key pressed - called in FieldViewController
    }

    public void hideView(){
    	mainPane.setVisible(false); //activate on TAB key release - called in FieldViewController

    }
	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

    public boolean isVisible(){
    	return mainPane.visibleProperty().get();
    }
    public void setStackRef(StackSet stack){
    	this.stackset = stack;
    }

	public void setStack(ObservableList<Set> sets) {

		pick_race_1.setImage(new Image("/images/races/active/"+sets.get(0).getRace().getName()+".png"));
		pick_race_2.setImage(new Image("/images/races/active/"+sets.get(1).getRace().getName()+".png"));
		pick_race_3.setImage(new Image("/images/races/active/"+sets.get(2).getRace().getName()+".png"));
		pick_race_4.setImage(new Image("/images/races/active/"+sets.get(3).getRace().getName()+".png"));
		pick_race_5.setImage(new Image("/images/races/active/"+sets.get(4).getRace().getName()+".png"));
		pick_race_6.setImage(new Image("/images/races/active/"+sets.get(5).getRace().getName()+".png"));

		pick_ability_1.setImage(new Image("/images/abilitys/active/"+sets.get(0).getAbility().getName()+".png"));
		pick_ability_2.setImage(new Image("/images/abilitys/active/"+sets.get(1).getAbility().getName()+".png"));
		pick_ability_3.setImage(new Image("/images/abilitys/active/"+sets.get(2).getAbility().getName()+".png"));
		pick_ability_4.setImage(new Image("/images/abilitys/active/"+sets.get(3).getAbility().getName()+".png"));
		pick_ability_5.setImage(new Image("/images/abilitys/active/"+sets.get(4).getAbility().getName()+".png"));
		pick_ability_6.setImage(new Image("/images/abilitys/active/"+sets.get(5).getAbility().getName()+".png"));



	}

	public void setBottomController(BottomBarController bottomBarController) {

		this.bottomBarController = bottomBarController;
	}
	public void updateActiveSet()
	{
		bottomBarController.setActiveSet();
	}





}
