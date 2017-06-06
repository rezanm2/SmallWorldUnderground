package abilities;

public class Vampire extends Ability
{
	public Vampire()
	{
		amountOfTokens = 5;
		type = "Vampire";
		traitText = "Replace one single opponent token with one single vampire token. That token is killed, even immortal.";
	}
}
