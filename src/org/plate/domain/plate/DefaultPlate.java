package org.plate.domain.plate;

public class DefaultPlate 
{
	private static Plate plate;
	private static Plate plate1;
	private static Plate plate2;
	
	public static Plate getPlate()
	{
		if (plate != null)
			return plate;
		
		plate = new Plate();
		
		plate.setPrefix("W");
		plate.setLetter1("U");
		plate.setLetter2("Y");
		plate.setNumber1("9");
		plate.setNumber2("1");
		plate.setNumber3("1");
		plate.setNumber4("9");
		plate.setSuffix("");
		
		plate.postCreateAlignValues();
		return plate;
	}
	
	
	public static Plate getPlate1()
	{
		if (plate1 != null)
			return plate1;
		
		plate1 = new Plate();
	
		
		plate1.setPrefix("W");
		plate1.setLetter1("X");
		plate1.setLetter2("Z");
		plate1.setNumber1("7");
		plate1.setNumber2("7");
		plate1.setNumber3("7");
		plate1.setNumber4("9");
		plate1.setSuffix("");
		
		plate1.postCreateAlignValues();
		return plate1;
	}
	
	public static Plate getPlate2()
	{
		if (plate2 != null)
			return plate2;
		
		plate2 = new Plate();

		
		plate2.setPrefix("P");
		plate2.setLetter1("G");
		plate2.setLetter2("E");
		plate2.setNumber1("2");
		plate2.setNumber2("7");
		plate2.setNumber3("2");
		plate2.setNumber4("7");
		plate2.setSuffix("");
		
		plate2.postCreateAlignValues();
		return plate2;
	}
}
