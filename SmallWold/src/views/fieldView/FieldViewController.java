package views.fieldView;

import java.rmi.RemoteException;
import java.util.ArrayList;


import abilities.Frightened;
import controllers.CombatController;
import controllers.RedeploymentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;

import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

public class FieldViewController {

	private TabViewController tabViewControl;
	private SideBarController sideBarControl;
	private StackPane declarePanePrevious = new StackPane();
	private int declaredTokenAmount;
	private int throughTheList = -1;

	private String tokenAmount;

	private CombatController combatController;// = new CombatController(test, 2, this, null); ////@@@@@@@@@@@@@@@@@@@@@@@@@@@@ remove later
	private RedeploymentController redploymentController;// = new RedeploymentController(test, 2, this, null);

	@FXML
	private TextField token_amount;


	@FXML
	private AnchorPane mainPane;
	private Player selfPlayer;



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
			if(this.selfPlayer.isMyTurn()){

			declaredTokenAmount = 0;

			HBox tokenBox = (HBox) event.getTarget();
			StackPane fieldPane = (StackPane) tokenBox.getParent();
			StackPane declarePane =(StackPane) fieldPane.getChildren().get(1); // (0) = hbox


			FlowPane flowPane = (FlowPane) declarePane.getChildren().get(1);


			HBox hbox = (HBox) flowPane.getChildren().get(1);
			TextField textField = (TextField) hbox.getChildren().get(1);
			textField.setText("0");

			declarePane.setVisible(true);
			this.declarePanePrevious.setVisible(false);
			this.declarePanePrevious = declarePane;
			throughTheList = 1;
			}

		} catch (ClassCastException e) {
			System.out.println("Je hebt hier al op geklikt. ");
		}
	}


	private void updateTokenAmountTextField(ActionEvent pressButton)
	{
		Button buttonMinTarget = (Button) pressButton.getTarget();
		HBox theBox = (HBox) buttonMinTarget.getParent();
		TextField field = (TextField) theBox.getChildren().get(1);

		field.setText(tokenAmount);

	}

	@FXML
	public void buttonMin(ActionEvent pressButtonMin) {
		if (declaredTokenAmount > 0 )
		{
			declaredTokenAmount = declaredTokenAmount - 1;
			tokenAmount = String.valueOf(declaredTokenAmount);

			updateTokenAmountTextField(pressButtonMin);
		}
	}

	@FXML
	public void buttonPlus(ActionEvent pressButtonPlus) {
		if(declaredTokenAmount < selfPlayer.getHand().getCurrentTokens()){
		declaredTokenAmount = declaredTokenAmount + 1;
		tokenAmount = String.valueOf(declaredTokenAmount);

		updateTokenAmountTextField(pressButtonPlus);
		}
	}

	@FXML
	public void buttonBevestig(ActionEvent pressButtonBevestig) throws RemoteException {
		//getDeclaredTokenAmount();
		combatController.declareTokenAmount(declaredTokenAmount);
		//redploymentController.declareTokenAmount(getDeclaredTokenAmount());
		System.out.println(declaredTokenAmount);
		this.declarePanePrevious.setVisible(false);

		throughTheList = -1;
		mainPane.requestFocus();

		System.out.println(declarePanePrevious.getParent().getId());



		this.combatController.calculateCombat(declarePanePrevious.getParent().getId());
		this.sideBarControl.hideDeclineButton();
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
	public void updateFieldById(String id, String raceName, int tokens) {

		ObservableList<Node> childList = this.mainPane.getChildren();

		for (Node node : childList) {

			if(node.getId() != null){
			if( node.getId().equals(id)){

				StackPane field = (StackPane) node;
				System.out.println(field);
				System.out.println(field.getChildren());
				HBox tokenBox = (HBox) field.getChildren().get(0);
				tokenBox.getChildren().clear(); //remove everything from the Hbox


				StackPane tokenPane = new StackPane();
				tokenBox.getChildren().add(tokenPane);

				ImageView tokenImage = new ImageView();
				System.out.println("/images/tokens/active/"+raceName+".png");
				tokenImage.setImage(new Image("/images/tokens/active/"+raceName+".png"));
				System.out.println("adding pic");

				Label tokenAmount = new Label();
				tokenAmount.setTextFill(Color.WHITE);
				tokenAmount.setFont(new Font(34));
				tokenAmount.setText(Integer.toString(tokens));

				System.out.println(tokenAmount);

				tokenPane.getChildren().addAll(tokenImage, tokenAmount);


			//	tokenBox.getChildren().add(tokenImage);
				break;
			}
			}
		}

}

	public void setRedeploymentController(RedeploymentController redeploymentController) {
		this.redploymentController = redeploymentController;
	}

	public void setPlayer(Player selfPlayer) {
		this.selfPlayer = selfPlayer;

	}
}
