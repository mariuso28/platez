package org.plate.json;

import java.util.List;

public class QueryParamsJson {
	
	private List<String> prefix;
	private List<String> letter1;
	private List<String> letter2;
	private List<String> number1;
	private List<String> number2;
	private List<String> number3;
	private List<String> number4;
	private List<String> suffix;
	private List<String[]> specials;
	
	public QueryParamsJson()
	{
	}

	public List<String> getPrefix() {
		return prefix;
	}

	public void setPrefix(List<String> prefix) {
		this.prefix = prefix;
	}

	public List<String> getLetter1() {
		return letter1;
	}

	public void setLetter1(List<String> letter1) {
		this.letter1 = letter1;
	}

	public List<String> getLetter2() {
		return letter2;
	}

	public void setLetter2(List<String> letter2) {
		this.letter2 = letter2;
	}

	public List<String> getNumber1() {
		return number1;
	}

	public void setNumber1(List<String> number1) {
		this.number1 = number1;
	}

	public List<String> getNumber2() {
		return number2;
	}

	public void setNumber2(List<String> number2) {
		this.number2 = number2;
	}

	public List<String> getNumber3() {
		return number3;
	}

	public void setNumber3(List<String> number3) {
		this.number3 = number3;
	}

	public List<String> getNumber4() {
		return number4;
	}

	public void setNumber4(List<String> number4) {
		this.number4 = number4;
	}

	public List<String> getSuffix() {
		return suffix;
	}

	public void setSuffix(List<String> suffix) {
		this.suffix = suffix;
	}

	public List<String[]> getSpecials() {
		return specials;
	}

	public void setSpecials(List<String[]> specials) {
		this.specials = specials;
	}
	
	
}
