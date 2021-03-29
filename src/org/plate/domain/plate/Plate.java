package org.plate.domain.plate;

import java.io.Serializable;

import org.plate.domain.plate.sell.PlateSell;

public class Plate implements Serializable{

	private static final long serialVersionUID = 6408530664952977270L;
	
	private long id;
	public static int RATINGNONE = 0;
	public static int RATINGGOLD = 1;
	public static int RATINGSILVER = 2;
	public static int RATINGBRONZE = 3;
	public static int LASTRATING = 3;
	
	private String prefix;
	private String letter1;
	private String letter2;
	private String number1;
	private String number2;
	private String number3;
	private String number4;
	private String suffix;
	private String regNo;
	
	private Boolean digit1;
	private Boolean digit2;
	private Boolean digit3;
	private Boolean digit4;
	private Boolean doubleDigit;
	private Boolean tripleDigit;
	private Boolean quadDigit;
	private Boolean palindromic;
	private Boolean paired;
	private int rating;
	private double listPrice;
	private PlateSell plateSell;
	
	public Plate()
	{
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	public Boolean getDigit1() {
		return digit1;
	}

	public void setDigit1(Boolean digit1) {
		this.digit1 = digit1;
	}

	public Boolean getDigit2() {
		return digit2;
	}

	public void setDigit2(Boolean digit2) {
		this.digit2 = digit2;
	}

	public Boolean getDigit3() {
		return digit3;
	}

	public void setDigit3(Boolean digit3) {
		this.digit3 = digit3;
	}

	public Boolean getDigit4() {
		return digit4;
	}

	public void setDigit4(Boolean digit4) {
		this.digit4 = digit4;
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

	public void setNumber(int num) {
		String str = Integer.toString(num);
		number1=str.substring(0,1);
		if (str.length()>1)
			number2=str.substring(1,2);
		else
			number2="";
		if (str.length()>2)
			number3=str.substring(2,3);
		else
			number3="";
		if (str.length()>3)
			number4=str.substring(3,4);
		else
			number4="";
	}

	public void postCreateAlignValues() {
		
		String text = getText(prefix,letter1,letter2,number1,
				 number2,number3,number4,suffix);
		setRegNo(text);
		
		String letters = getValueNotNull(letter1) + getValueNotNull(letter2);
		setLetter1("");
		setLetter2("");
		if (!letters.isEmpty())
		{
			letter1 = letters.substring(0,1);
			if (letters.length()>1)
				letter2 = letters.substring(1,2);
		}
	
		String numbs = getValueNotNull(number1) + getValueNotNull(number2) + getValueNotNull(number3) +  getValueNotNull(number4);
		setNumber1("");
		setNumber2("");
		setNumber3("");
		setNumber4("");
		if (!numbs.isEmpty())
		{
			number1 = numbs.substring(0,1);
			if (numbs.length()>1)
			{
				number2 = numbs.substring(1,2);
				if (numbs.length()>2)
				{
					number3 = numbs.substring(2,3);
					if (numbs.length()>3)
					{
						number4 = numbs.substring(3,4);
					}
				}
			}
		}
		
		setSuffix(getValueNotNull(suffix));
		setSpecials();
	}

	private static String getText(String prefix,String letter1,String letter2,String number1,
			String number2,String number3,String number4,String suffix)
	{
		String text = "" + getValueNotNull(prefix);
		text += getValueNotNull(letter1) + getValueNotNull(letter2);
		text += " " + getValueNotNull(number1) + getValueNotNull(number2) + getValueNotNull(number3) 
		+ getValueNotNull(number4);
		if (suffix != null && !suffix.isEmpty())
			text += " " + suffix;
		return text;
	}
	
	private static String getValueNotNull(String field)
	{
		if (field == null)
			return "";
		return field;
	}

	public void setSpecials()
	{
		regNo = prefix + " " + letter1 + letter2 + number1 + number2 + number3 + number4 + " " + suffix;
		regNo = regNo.trim();
		digit1 = number2.isEmpty();
		digit2 = !number2.isEmpty() && number3.isEmpty();
		digit3 = !number2.isEmpty() && !number3.isEmpty() && number4.isEmpty();
		digit4 = !number2.isEmpty() && !number3.isEmpty() && !number4.isEmpty();
		doubleDigit = digit2 && number2.equals(number1);
		tripleDigit = digit3 && number2.equals(number1)  && number3.equals(number1);
		quadDigit = digit4 && number2.equals(number1)  && number3.equals(number1) && number4.equals(number1);
		palindromic = doubleDigit || (digit3 && number1.equals(number3))
				|| (digit4 && number1.equals(number4) && number2.equals(number3));
		paired = digit4 && number1.equals(number3) && number2.equals(number4);
	}
	
	public String getSpecials() {
		return "digit1=" + digit1 + ", digit2=" + digit2 + ", digit3=" + digit3 + ", digit4="
				+ digit4 + ", doubleDigit=" + doubleDigit + ", tripleDigit=" + tripleDigit + ", quadDigit=" + quadDigit
				+ ", palindromic=" + palindromic + ", paired=" + paired + "]";
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
		this.listPrice = listPrice;
		if (listPrice>=8000.0)
			setRating(Plate.RATINGGOLD);
		else
		if (listPrice>=3000.0)
			setRating(Plate.RATINGSILVER);
		else
		if (listPrice>=0.0)
			setRating(Plate.RATINGBRONZE);
	}

	public PlateSell getPlateSell() {
		return plateSell;
	}

	public void setPlateSell(PlateSell plateSell) {
		this.plateSell = plateSell;
	}

	@Override
	public String toString() {
		return "Plate [id=" + id + ", prefix=" + prefix + ", letter1=" + letter1 + ", letter2=" + letter2 + ", number1="
				+ number1 + ", number2=" + number2 + ", number3=" + number3 + ", number4=" + number4 + ", suffix="
				+ suffix + ", regNo=" + regNo + ", digit1=" + digit1 + ", digit2=" + digit2 + ", digit3=" + digit3
				+ ", digit4=" + digit4 + ", doubleDigit=" + doubleDigit + ", tripleDigit=" + tripleDigit
				+ ", quadDigit=" + quadDigit + ", palindromic=" + palindromic + ", paired=" + paired + ", rating="
				+ rating + ", listPrice=" + listPrice + ", plateSell=" + plateSell + "]";
	}
	

}
