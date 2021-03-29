package org.plate.importer;

public class PlateParseException extends Exception {

	private static final long serialVersionUID = 4401409642115134696L;

	public PlateParseException(String message)
	{
		super(message);
	}
	
	public PlateParseException(String message, String chunk)
	{
		super(message + " in plate chunk : " + 
				chunk.substring(0,chunk.length()>10?10:chunk.length()));
	}
}