package org.plate.json;

public class PlateJson {

	public static int RATINGNONE = 0;
	public static int RATINGGOLD = 1;
	public static int RATINGSILVER = 2;
	public static int RATINGBRONZE = 3;
	public static int LASTRATING = 3;
	private long id;
	private String regNo;
	private int rating;
	private double listPrice;
	private PlateSellJson plateSell;
	
	public PlateJson()
	{
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlateSellJson getPlateSell() {
		return plateSell;
	}

	public void setPlateSell(PlateSellJson plateSell) {
		this.plateSell = plateSell;
	}

	
}
