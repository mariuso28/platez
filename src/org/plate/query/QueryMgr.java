package org.plate.query;

import java.util.ArrayList;
import java.util.List;

public class QueryMgr {
	
	public QueryMgr()
	{
	}
	
	public void validate(QueryOnPlateParams params) throws QueryException
	{
		List<String> invalid = new ArrayList<String>();
		params.setPrefix(prepareChars(params.getPrefix()));
		if (!checkLetters(params.getPrefix(),3))
			invalid.add("Prefix");
		params.setLetter1(prepareChars(params.getLetter1()));
		if (!checkLetters(params.getLetter1(),1))
			invalid.add("letter1");	
		params.setLetter2(prepareChars(params.getLetter2()));
		if (!checkLetters(params.getLetter2(),1))
			invalid.add("letter2");	
		params.setSuffix(prepareChars(params.getSuffix()));
		if (!checkLetters(params.getSuffix(),3))
			invalid.add("Sufix");
		params.setNumber1(prepareNumeric(params.getNumber1()));
		if (!checkNumeric(params.getNumber1()))
			invalid.add("number1");
		params.setNumber2(prepareNumeric(params.getNumber2()));
		if (!checkNumeric(params.getNumber2()))
			invalid.add("number2");
		params.setNumber3(prepareNumeric(params.getNumber3()));
		if (!checkNumeric(params.getNumber3()))
			invalid.add("number3");
		params.setNumber4(prepareNumeric(params.getNumber4()));
		if (!checkNumeric(params.getNumber4()))
			invalid.add("number4");
		if (invalid.isEmpty())
			return;
		String msg = "Invalid fields in Plate Query : ";
		for (String field : invalid)
			msg += field + ",";
		throw new QueryException(msg.substring(0,msg.length()-1));
	}
	
	private String prepareNumeric(String str)
	{
		if (str == null)
			return "";
		return str.trim();
	}
	
	private boolean checkNumeric(String number) {
		if (number.isEmpty())
			return true;
		if (number.length()>1)
			return false;
		return Character.isDigit(number.charAt(0));
	}

	private String prepareChars(String str)
	{
		if (str == null)
			return "";
		str = str.trim();
		str = str.toUpperCase();
		return str;
	}
	
	private boolean checkLetters(String str, int len) {
		if (str.isEmpty())
			return true;
		if (str.length()>len)
			return false;
		for (int i=0; i<str.length(); i++)
		{
			int type = Character.getType(str.charAt(i));
			if (type != Character.UPPERCASE_LETTER)
				return false;
		}
		return true;
	}

}
