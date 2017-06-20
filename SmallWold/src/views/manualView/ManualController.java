package views.manualView;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ManualController {
	@FXML
	private ImageView manualPage;
	
	@FXML
	private Pane mainPane;
	
	private int count= 0;
	
	public void next()
	{
		if(count > 15)
		{
			count = 0;
		}
		count++;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".png"));
	}
	public void previous()
	{
		if(count < 2)
		{
			count = 17;
		}
		count--;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".png"));
	}
	
	public void openManual()
	{
		if(mainPane.isVisible())
		{
			this.mainPane.setVisible(false);
		}
		else
		{
			this.mainPane.setVisible(true);
		}
		//this.manualPage.setImage(new Image("/images/manual/manual1.jpg"));
	}

}
