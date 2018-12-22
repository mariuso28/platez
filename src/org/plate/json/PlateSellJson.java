package org.plate.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlateSellJson {
	private long id;
	private long plateId;
	private String sellerEmail;
	private Date sellDate;
	private List<PlateOfferJson> offers = new ArrayList<PlateOfferJson>();
	private int offersDistinctCount;
	private PlateSellStatusJson status;
	
	public PlateSellJson()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public List<PlateOfferJson> getOffers() {
		return offers;
	}

	public void setOffers(List<PlateOfferJson> offers) {
		this.offers = offers;
	}

	public long getPlateId() {
		return plateId;
	}

	public void setPlateId(long plateId) {
		this.plateId = plateId;
	}

	public int getOffersDistinctCount() {
		return offersDistinctCount;
	}

	public void setOffersDistinctCount(int offersDistinctCount) {
		this.offersDistinctCount = offersDistinctCount;
	}

	public PlateSellStatusJson getStatus() {
		return status;
	}

	public void setStatus(PlateSellStatusJson status) {
		this.status = status;
	}
	
	

}
