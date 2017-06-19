package views.fieldView;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

    @FXML
    StackPane screenButtons;

    @FXML
    private void onClick(MouseEvent event){
    try {
	StackPane screenButtons = (StackPane) event	.getTarget();
	screenButtons.getChildren();
	StackPane stackPane = (StackPane)screenButtons.getChildren().get(0);
	stackPane.setVisible(true);
    } catch (ClassCastException  e){
    	System.out.println("Je hebt hier al op geklikt. ");
    }




//	Image view laten zien
//	StackPane stackPane = (StackPane) event.getTarget();
//	stackPane.getChildren();
//	ImageView imageView  = (ImageView)stackPane.getChildren().get(0);
//	System.out.println(imageView);
//	imageView.setVisible(true);
    }
}
