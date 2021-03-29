package org.plate.query;

import java.util.ArrayList;
import java.util.List;

public class QueryParams 
{
	public static List<String> getValidLetter() {
		List<String> list = new ArrayList<String>();
		list.add("");
		for (char c='A'; c<'Z'; c++)
			if (c!='O' && c!='I')
			list.add(Character.toString(c));
		return list;
	}
	
	public static List<String> getValidNumber1() {
		List<String> list = new ArrayList<String>();
		list.add("");
		for (char c='1'; c<='9'; c++)
			list.add(Character.toString(c));
		return list;
	}
	
	public static List<String> getValidNumber() {
		List<String> list = new ArrayList<String>();
		list.add("");
		for (char c='0'; c<='9'; c++)
			list.add(Character.toString(c));
		list.add("");
		return list;
	}

	public static List<String> getValidPrefix()
	{
		List<String> list = new ArrayList<String>();
		list.add("W");
		list.add("P");
		list.add("J");
		list.add("K");
		list.add("KV");
		list.add("D");
		list.add("M");
		list.add("N");
		list.add("M");
		list.add("C");
		list.add("A");
		list.add("R");
		list.add("B");
		list.add("T");
		list.add("SA");
		list.add("SS");
		list.add("SK");
		list.add("ST");
		list.add("SB");
		list.add("SU");
		list.add("SD");
		list.add("QA");
		list.add("QS");
		list.add("QM");
		list.add("QB");
		list.add("QR");
		list.add("QT");
		list.add("QL");
		list.add("QC");
		list.add("QP");
		list.add("L");
		return list;
	}
	
	public static List<String> getValidSuffix()
	{
		List<String> suffix = new ArrayList<String>();
		suffix.addAll(getValidLetter());
		return suffix;
	}
	
	public static List<String[]> getValidSpecials() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[]{"1 Digit Numbers","digit1"});
		list.add(new String[]{"2 Digit Numbers","digit2"});
		list.add(new String[]{"3 Digit Numbers","digit3"});
		list.add(new String[]{"4 Digit Numbers","digit4"});
		list.add(new String[]{"Double Digit Numbers (e.g. 22)","doubleDigit"});
		list.add(new String[]{"Triple Digit Numbers (e.g. 333)","tripleDigit"});
		list.add(new String[]{"Quadruple Digit Numbers (e.g. 8888)","quadDigit"});
		list.add(new String[]{"Palindromic Numbers (e.g. 8228, 4334, 212, 747)","palindromic"});
		list.add(new String[]{"Paired Numbers (e.g. 1212, 2828)","paired"});
		return list;
	}
}
