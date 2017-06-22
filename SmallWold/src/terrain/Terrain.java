package terrain;

import races.Race;
import relics.Relic;
//import specialPlaces.Empty;
import specialPlaces.SpecialPlace;
import specialTokens.SpecialToken;
/**
 * Klasse terrain is verantwoordelijk voor het bijhouden van de inhoud van een specifiek terrein.
 *
 * @author Marinus van den Oever;
 *
 */
public abstract class Terrain
{
	protected String[] idArray;
	protected String tokenType;
	protected int amountOfTokens;
	protected int defense;
	protected String terrainName;

	protected Race race;

	protected boolean isAdjacent;
	protected boolean isAttackable;
	protected boolean isRedeployable;
	protected boolean isImmune;

	protected Relic relic = new relics.Empty();
	protected SpecialPlace specialPlace;
	protected SpecialToken specialToken = new specialTokens.Empty();

	public Terrain(String[] idArray)
	{

		this.idArray = idArray;
	}

	public void setElement(int arrayOrder)
	{
		this.idArray[arrayOrder] = idArray[arrayOrder];
	}

	public String getElement(int arrayOrder)
	{
		return idArray[arrayOrder];
	}

	public void setIdArray(String[] idArray)
	{
		this.idArray = idArray;
	}

	public String[] getIdArray()
	{
		return idArray;
	}

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}


	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}


	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public void setIsAdjacent(boolean isAdjacent) {
		this.isAdjacent = isAdjacent;
	}

	public boolean getIsAdjacent() {
		return isAdjacent;
	}

	public void setIsRedeployable(boolean isRedeployable) {
		this.isRedeployable = isRedeployable;
	}

	public boolean getIsRedeployable() {
		return isRedeployable;
	}

	public void setToOne() {
		setAmountOfTokens(1);
	}

	public void setIsImmune(boolean isImmune)
	{
		this.isImmune = isImmune;
	}

	public boolean getIsImmune()
	{
		return isImmune;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;

	}

	public String getTokenType() {
		return tokenType;
	}

	public void setRelic(Relic relic)
	{
		this.relic = relic;
	}

	public Relic getRelic()
	{
		return relic;
	}

	public SpecialToken getSpecialToken() {
		return specialToken;
	}

	public void setSpecialToken(SpecialToken specialToken) {
		this.specialToken = specialToken;
	}

	public void setSpecialPlace(SpecialPlace specialPlace)
	{
		this.specialPlace = specialPlace;
	}

	public SpecialPlace getSpecialPlace()
	{
		return specialPlace;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getTerrainName() {
		return terrainName;
	}

	public void setTerrainName(String terrainName) {
		this.terrainName = terrainName;
	}
	public boolean getIsAttackable() {
		return isAttackable;
	}

	public void setIsAttackable(boolean isAttackable) {
		this.isAttackable = isAttackable;
	}
}
