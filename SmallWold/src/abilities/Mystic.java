package abilities;

import java.util.List;

import controllers.CombatController;

import player.Player;

public class Mystic extends Ability
{
	private int abilityIncome;
	Player activePlayer;
	CombatController cc;

	public Mystic()
	{
		amountOfTokens = 4;
		type = "Mystic";
		traitText = "+1 coin for each mystic region";
	}

	public void calculateAbility(Player activePlayer){
		this.activePlayer = activePlayer;
		cc.checkTerrainType("Mystic");
		this.setAbilityIncome(cc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public CombatController getCc() {
		return cc;
	}

	public void setCc(CombatController cc) {
		this.cc = cc;
	}


}
