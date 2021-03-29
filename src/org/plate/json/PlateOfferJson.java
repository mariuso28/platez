package org.plate.json;

import java.util.Date;

public class PlateOfferJson {
	
	private long id;
	private String buyerEmail;
	private String regNo;
	private double offer;
	private Date offeredOn;
	private PlateOfferStatusJson status;
	
	public PlateOfferJson()
	{
		setStatus(PlateOfferStatusJson.OFFERED);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public Date getOfferedOn() {
		return offeredOn;
	}

	public void setOfferedOn(Date offeredOn) {
		this.offeredOn = offeredOn;
	}

	public PlateOfferStatusJson getStatus() {
		return status;
	}

	public void setStatus(PlateOfferStatusJson status) {
		this.status = status;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	
}
