package views.fieldView;

import java.beans.EventHandler;

import abilities.Frightened;
import controllers.CombatController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.Set;
import player.Player;
import races.Drow;
import races.Flames;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

public class FieldViewController {

	private TabViewController tabViewControl;
	private SideBarController sideBarControl;
	private StackPane declarePanePrevious = new StackPane();
	private int declaredTokenAmount;
	private int throughTheList = -1;
	private Set testset = new Set(new Frightened(), new Flames());
	private Player test = new Player(testset);

	private CombatController combatController = new CombatController(test, 2, this, null); ////@@@@@@@@@@@@@@@@@@@@@@@@@@@@ remove later


	@FXML
	private TextField token_amount;

	@FXML
	private AnchorPane mainPane;


	public FieldViewController() {

	}

	public void setControllers(TabViewController tabControl, SideBarController sideControl) {
		tabViewControl = tabControl;
		sideBarControl = sideControl;
	}

	@FXML
	public void keyPressed(KeyEvent ke) {
		if (ke.getCode().equals(KeyCode.TAB)) {
			tabViewControl.showView();
			sideBarControl.changeImagePressed();
		}
		else if(ke.getCode().equals(KeyCode.RIGHT)){
			arrowKeyPressedRight(ke);
		}
		else if(ke.getCode().equals(KeyCode.LEFT)){
			arrowKeyPressedLeft(ke);
		}
		else if(ke.getCode().equals(KeyCode.ADD) || (ke.getCode().equals(KeyCode.EQUALS))){
			declaredTokenAmount = declaredTokenAmount + 1;
			String tokenAmount = String.valueOf(declaredTokenAmount);
			token_amount.setText(tokenAmount);
		}
		else if(ke.getCode().equals(KeyCode.MINUS) || (ke.getCode().equals(KeyCode.SUBTRACT))){
			if (declaredTokenAmount > 0) {
				declaredTokenAmount = declaredTokenAmount - 1;
				String tokenAmount = String.valueOf(declaredTokenAmount);
				token_amount.setText(tokenAmount);
			}

		}
	}

	@FXML
	public void keyReleased(KeyEvent ke) {
		if (ke.getCode().equals(KeyCode.TAB)) {
			tabViewControl.hideView();
			sideBarControl.changeImageReleased();
		}
	}



	@FXML
	public void declareTokenClick(MouseEvent event) {
		try {
			StackPane field = (StackPane) event.getTarget();
			StackPane declarePane = (StackPane) field.getChildren().get(0);
			declarePane.setVisible(true);
			this.declarePanePrevious.setVisible(false);
			this.declarePanePrevious = declarePane;
			throughTheList = 1;


		} catch (ClassCastException e) {
			System.out.println("Je hebt hier al op geklikt. ");
		}
	}

	@FXML
	public void buttonMin(ActionEvent pressButtonMin) {
		if (declaredTokenAmount > 0) {
			declaredTokenAmount = declaredTokenAmount - 1;
			String tokenAmount = String.valueOf(declaredTokenAmount);
			token_amount.setText(tokenAmount);
		}
	}

	@FXML
	public void buttonPlus(ActionEvent pressButtonPlus) {
		declaredTokenAmount = declaredTokenAmount + 1;
		String tokenAmount = String.valueOf(declaredTokenAmount);
		token_amount.setText(tokenAmount);
	}

	@FXML
	public void buttonBevestig(ActionEvent pressButtonBevestig) {
		getDeclaredTokenAmount();
		System.out.println(declaredTokenAmount);
		this.declarePanePrevious.setVisible(false);

		throughTheList = -1;
		mainPane.requestFocus();

		System.out.println(declarePanePrevious.getParent().getId());
		this.combatController.testTerrain(declarePanePrevious.getParent().getId());
	}

	public int getDeclaredTokenAmount() {
		return declaredTokenAmount;
	}

	public void setDeclaredTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}

	@FXML
	public void arrowKeyPressedLeft(KeyEvent key) {
		if (key.getCode() == KeyCode.LEFT) {
			System.out.println("Left arrow key is pressed");

			if (throughTheList > 0) {
			throughTheList = throughTheList - 1;
			StackPane throughTheTerrain = (StackPane) mainPane.getChildren().get(throughTheList);
			StackPane declarePane = (StackPane) throughTheTerrain.getChildren().get(0);
			declarePane.setVisible(true);
			this.declarePanePrevious.setVisible(false);
			this.declarePanePrevious = declarePane;
			}
		}
	}
	@FXML
	public void arrowKeyPressedRight(KeyEvent key){
		if (key.getCode() == KeyCode.RIGHT) {
			System.out.println("Right arrow key is pressed");

			throughTheList = throughTheList + 1;
			StackPane throughTheTerrain = (StackPane) mainPane.getChildren().get(throughTheList);
			StackPane declarePane = (StackPane) throughTheTerrain.getChildren().get(0);
			declarePane.setVisible(true);
			this.declarePanePrevious.setVisible(false);
			this.declarePanePrevious = declarePane;
		}
	}

	public void setCombatController(CombatController combatController) {
		this.combatController = combatController;

	}
}
