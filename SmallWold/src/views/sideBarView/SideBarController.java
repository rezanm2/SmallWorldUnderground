package views.sideBarView;

import controllers.TurnController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import player.Player;
import views.manualView.ManualController;
import views.tabView.TabViewController;


public class SideBarController {

    private TabViewController tabViewControl;
    private ManualController manualController;
    private Player selfPlayer;
    private TurnController turnControl;

    @FXML
    private ImageView tabImage;

    @FXML
    private Label turn_label;

    @FXML
    private ImageView endTurnButton;


    public SideBarController() {
		// TODO Auto-generated constructor stub
	}


    public void setControllers(TabViewController controller){
    	tabViewControl = controller;
    }
    public void setControllers(ManualController controller){
    	manualController = controller;
    }

    public void changeImagePressed(){
    	tabImage.setImage(new Image("/images/icons/tab-bar-stripes-pressed.png"));
    }
    public void changeImageReleased(){
    	tabImage.setImage(new Image("/images/icons/tab-bar-stripes.png"));
    }

    @FXML
    private void tabButtonPress() {
    	if(!tabViewControl.isVisible()){
    		tabImage.setImage(new Image("/images/icons/tab-bar-stripes-pressed.png"));
    		tabViewControl.showView();
    	}else{
    		tabViewControl.hideView();
    		tabImage.setImage(new Image("/images/icons/tab-bar-stripes.png"));
    	}

    }
    public void openManual()
    {
    	manualController.openManual();
    }

	public void UpdateText(String message) {
		turn_label.setText(message);
	}


	public void setPlayer(Player selfPlayer) {
		this.selfPlayer = selfPlayer;

	}
	public void setTurnController(TurnController turnController){
		this.turnControl = turnController;
	}

	public void endTurn(){
		turnControl.calculateNewBalance();
	}

}
