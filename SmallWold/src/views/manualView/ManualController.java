package views.manualView;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ManualController {
	@FXML
	private ImageView manualPage;
	
	private int count= 0;
	
	public void next()
	{
		if(count > 16)
		{
			count = 0;
		}
		count++;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".jpg"));
	}
	public void previous()
	{
		if(count < 0)
		{
			count = 16;
		}
		count--;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".jpg"));
	}
	
	public void openManual()
	{
		this.manualPage.setImage(new Image("/images/manual/manual1.jpg"));
	}

}
