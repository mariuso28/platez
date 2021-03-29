package org.plate.importer;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;

public class PlateParseRule {
	private static Logger log = Logger.getLogger(PlateParseRule.class);
	
	
	private String chunk;
	private String number;
	private String letters;
	private String price;
	private Plate plate;
	private String prefix;
	private String suffix;
	
	public PlateParseRule(String chunk) throws PlateParseException
	{
		setChunk(chunk);
		log.info("Parsing : " + chunk);
		parseChunk();
		plate = new Plate();
		
		if (prefix.length()<2)
			prefix += "";
		plate.setPrefix(prefix.toUpperCase());
		if (suffix.length()==1)
		{
			suffix += "";
			plate.setSuffix(suffix.toUpperCase());
		}
		plate.setNumber1("");
		plate.setNumber2("");
		plate.setNumber3("");
		plate.setNumber4("");
		if (!number.isEmpty())
			plate.setNumber(Integer.parseInt(number));
		if (letters.length()>0)
		{
			plate.setLetter1(letters.substring(0,1).toUpperCase());
			if (letters.length()>1)
			{
				plate.setLetter2(letters.substring(1,2).toUpperCase());
			}
			else
				plate.setLetter2("");
		}
		else
			plate.setLetter1("");
		plate.postCreateAlignValues();
		double priceVal = Double.parseDouble(price);
		plate.setListPrice(priceVal);
	}
	
	public void parseChunk() throws PlateParseException
	{
		int startPrefix = getPrefix();
		int startLetters = getLetters(startPrefix);
		int startNumber = getStartNumber(startLetters);
		int endNumber = getNumber(startNumber);				// end of number
		int startPrice = getPrice(endNumber);				// start of price
		getSuffix(endNumber+1,startPrice);
	}

	private void getSuffix(int pos, int end) {
		suffix = "";
		while (pos!=end)
			if (isAlpha(chunk.charAt(pos)))
			{
				suffix += chunk.charAt(pos++);
			}
			else
				pos++;
		suffix = suffix.trim();
	}

	private int getLetters(int pos) {
		
		letters = "";
		while (pos!=chunk.length() && Character.isSpaceChar(chunk.charAt(pos)))
			pos++;
		
		while (pos!=chunk.length())
		{
			if (isAlpha(chunk.charAt(pos)))
			{
				letters += chunk.charAt(pos++);
			}
			else
				break;
		}
		letters = letters.trim();
		return pos;
	}

	private boolean isAlpha(char ch)
	{
		return (Character.toUpperCase(ch)>='A' && Character.toUpperCase(ch)<='Z');
	}
	
	private int getPrefix() throws PlateParseException {
		int pos = 0;
		prefix = "";
		while (pos!=chunk.length())
			if (isAlpha(chunk.charAt(pos)))
			{
				prefix += chunk.charAt(pos++);
			}
			else
				break;
		
		prefix = prefix.trim();
		if (prefix.isEmpty())
			throw new PlateParseException("No Prefix", chunk);
		return pos;
	}

	private int getStartNumber(int pos) throws PlateParseException {
		boolean found = false;
		while (pos!=chunk.length())
			if (Character.isDigit(chunk.charAt(pos)))
			{
				found = true;
				break;
			}
			else
				pos++;
				
		if (!found)
			throw new PlateParseException("No Number", chunk);
		return pos;
	}

	private int getNumber(int pos) throws PlateParseException
	{	
		number = "";
		while (pos!=chunk.length())
		{
			char ch = chunk.charAt(pos);
			if (Character.isDigit(ch))
				number += chunk.charAt(pos++);
			else
			if (ch=='.' || ch==',')
				pos++;
			else 
				break;
		}
		return pos;
	}
	
	private int getPrice(int pos) throws PlateParseException
	{
		boolean found = false;
		while (pos!=chunk.length())
		{
			if (Character.isDigit(chunk.charAt(pos)))
			{
				found = true;
				break;
			}
			pos++;
		}
				
		if (!found)
			throw new PlateParseException("No Price", chunk);
		
		int spos = pos;
		price = "";
		while (pos!=chunk.length())
		{
			char ch = chunk.charAt(pos);
			if (Character.isDigit(ch))
				price += chunk.charAt(pos++);
			else
				if (ch=='.' || ch==',')
				{
					pos++;
					continue;
				}
				else
					break;
		}
		
		if (price.isEmpty())
			throw new PlateParseException("No Price", chunk);
		return spos;
	}
	
	public String getChunk() {
		return chunk;
	}

	public void setChunk(String chunk) {
		this.chunk = chunk;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public static void main(String[] args)
	{
		PlateParseRule pr = null;
		try {
			pr = new PlateParseRule("W B 800 W 5800");
			System.out.println("Parsed W B 800 W 5800 to : " + pr.getPlate());
			pr = new PlateParseRule("P MK 2828 6000");
			System.out.println("Parsed PMK 2828 6000 to : " + pr.getPlate());
		} catch (PlateParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}