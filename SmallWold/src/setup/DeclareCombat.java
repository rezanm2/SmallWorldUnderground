package setup;

import controllers.CombatController;

public class DeclareCombat
{
	CombatController cc;

	public DeclareCombat(CombatController cc)
	{
		this.cc = cc;
	}

	public void start()
	{
		System.out.println("All right. Let's start attacking some stuff.");
	}
}
