package views.sideBarView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.tabView.TabViewController;


public class SideBarController {

    private TabViewController tabViewControl;

    @FXML
    private ImageView tabImage;

    @FXML
    private Label turn_label;


    public SideBarController() {
		// TODO Auto-generated constructor stub
	}


    public void setControllers(TabViewController controller){
    	tabViewControl = controller;
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


	public void UpdateText(String message) {
		turn_label.setText(message);
	}
}
