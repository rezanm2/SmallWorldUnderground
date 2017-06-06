package abilities;

public class Tomb extends Ability
{
	public Tomb()
	{
		amountOfTokens = 5;
		type = "Tomb";
		traitText = "Redeploy once more before going in decline, then keep all tokens. At end of turn, if your tokens were conquered, redeploy them.";
	}
}
