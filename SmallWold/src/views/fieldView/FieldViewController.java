package views.fieldView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

public class FieldViewController {

    private TabViewController tabViewControl;
    private SideBarController sideBarControl;
    private StackPane declarePanePrevious = new StackPane();
    private int declaredTokenAmount;

    @FXML
    private TextField token_amount;

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
    private void declareTokenClick(MouseEvent event){
    	try {
    		StackPane field = (StackPane) event.getTarget();
    		StackPane declarePane = (StackPane)field.getChildren().get(0);
    		declarePane.setVisible(true);
    		this.declarePanePrevious.setVisible(false);
    		this.declarePanePrevious = declarePane;

    	} 	catch (ClassCastException  e){
    		System.out.println("Je hebt hier al op geklikt. ");
    	}
    }

    @FXML
    private void buttonMin (ActionEvent pressButtonMin){
    	if(declaredTokenAmount > 0){
    		declaredTokenAmount = declaredTokenAmount - 1;
    		String tokenAmount = String.valueOf(declaredTokenAmount);
    		token_amount.setText(tokenAmount);
    	}
    }

    @FXML
    private void buttonPlus (ActionEvent pressButtonPlus){
    	declaredTokenAmount = declaredTokenAmount + 1;
    	String tokenAmount = String.valueOf(declaredTokenAmount);
    	token_amount.setText(tokenAmount);
    }

    @FXML
    private void buttonBevestig (ActionEvent pressButtonBevestig){
    	getDeclaredTokenAmount();
    	System.out.println(declaredTokenAmount);
    	this.declarePanePrevious.setVisible(false);
    }

	public int getDeclaredTokenAmount() {
		return declaredTokenAmount;
	}

	public void setDeclaredTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}


}
