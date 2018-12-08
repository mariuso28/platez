package org.plate.query;

public class QueryOnPlateParams{
	private String prefix;
	private String letter1;
	private String letter2;
	private String number1;
	private String number2;
	private String number3;
	private String number4;
	private String suffix;
	
	
	public QueryOnPlateParams()
	{
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getLetter1() {
		return letter1;
	}

	public void setLetter1(String letter1) {
		this.letter1 = letter1;
	}

	public String getLetter2() {
		return letter2;
	}

	public void setLetter2(String letter2) {
		this.letter2 = letter2;
	}

	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public String getNumber3() {
		return number3;
	}

	public void setNumber3(String number3) {
		this.number3 = number3;
	}

	public String getNumber4() {
		return number4;
	}

	public void setNumber4(String number4) {
		this.number4 = number4;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "QueryOnPlateParams [prefix=" + prefix + ", letter1=" + letter1 + ", letter2=" + letter2 + ", number1="
				+ number1 + ", number2=" + number2 + ", number3=" + number3 + ", number4=" + number4 + ", suffix="
				+ suffix + "]";
	}
	
}
