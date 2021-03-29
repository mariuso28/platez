package org.plate.domain.plate.sell;

import java.util.Date;

import org.plate.json.PlateOfferStatusJson;

public class PlateOffer {
	
	private long id;
	private String buyerEmail;
	private PlateSell plateSell;
	private double offer;
	private Date offeredOn;
	private String regNo;
	private PlateOfferStatusJson status;
	
	public PlateOffer()
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

	public PlateSell getPlateSell() {
		return plateSell;
	}

	public void setPlateSell(PlateSell plateSell) {
		this.plateSell = plateSell;
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

	@Override
	public String toString() {
		return "PlateOffer [id=" + id + ", buyerEmail=" + buyerEmail + ", plateSell=" + plateSell + ", offer=" + offer
				+ ", offeredOn=" + offeredOn + ", status=" + status + "]";
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
}
