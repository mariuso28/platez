package org.plate.query;

public class QueryOnDigitsParams {
	private Boolean doubleDigit;
	private Boolean tripleDigit;
	private Boolean quadDigit;
	private Boolean palindromic;
	private Boolean paired;
	
	public QueryOnDigitsParams()
	{
	}

	public Boolean getDoubleDigit() {
		return doubleDigit;
	}

	public void setDoubleDigit(Boolean doubleDigit) {
		this.doubleDigit = doubleDigit;
	}

	public Boolean getTripleDigit() {
		return tripleDigit;
	}

	public void setTripleDigit(Boolean tripleDigit) {
		this.tripleDigit = tripleDigit;
	}

	public Boolean getQuadDigit() {
		return quadDigit;
	}

	public void setQuadDigit(Boolean quadDigit) {
		this.quadDigit = quadDigit;
	}

	public Boolean getPalindromic() {
		return palindromic;
	}

	public void setPalindromic(Boolean palindromic) {
		this.palindromic = palindromic;
	}

	public Boolean getPaired() {
		return paired;
	}

	public void setPaired(Boolean paired) {
		this.paired = paired;
	}

	@Override
	public String toString() {
		return "QueryOnDigitsParams [doubleDigit=" + doubleDigit + ", tripleDigit=" + tripleDigit + ", quadDigit="
				+ quadDigit + ", palindromic=" + palindromic + ", paired=" + paired + "]";
	}
	
}
