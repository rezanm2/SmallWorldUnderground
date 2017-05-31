package races;

public abstract class Race
{
	protected int amountOfTokens;
	protected int maxTokens;
	protected String tokenType;
	protected String traitText;

	public Race()
	{
	}

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}
	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}

	public void setMaxTokens(int maxTokens)
	{
		this.maxTokens = maxTokens;
	}

	public int getMaxTokens()
	{
		return maxTokens;
	}

	public void setTokenType(String tokenType)
	{
		this.tokenType = tokenType;
	}

	public String getTokenType()
	{
		return tokenType;
	}

	public void setTraitText(String traitText)
	{
		this.traitText = traitText;
	}
	public String getTraitText()
	{
		return traitText;
	}
}

