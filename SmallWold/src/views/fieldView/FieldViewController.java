package views.fieldView;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

public class FieldViewController {

    private TabViewController tabViewControl;
    private SideBarController sideBarControl;


    public FieldViewController() {

	}

    public void setControllers(TabViewController tabControl, SideBarController sideControl ){
    	tabViewControl = tabControl;
    	sideBarControl = sideControl;
    }


    @FXML
    private void keyPressed(KeyEvent ke) {
    	if (ke.getCode().equals(KeyCode.TAB)){
    		tabViewControl.showView();
    		sideBarControl.changeImagePressed();
    	}
    }

    @FXML
    private void keyReleased(KeyEvent ke) {
    	if (ke.getCode().equals(KeyCode.TAB)){
    		tabViewControl.hideView();
    		sideBarControl.changeImageReleased();
    	}
    }
}
