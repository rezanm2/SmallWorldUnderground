package specialPlaces;

import main.Ammy;

public class Empty extends SpecialPlace{

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	public void processSpecialPlace(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

}
