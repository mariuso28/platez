package org.plate.json;

public class SendPlateOfferJson {
	
	private long plateId;
	private String offer;
	
	public SendPlateOfferJson()
	{
	}

	public long getPlateId() {
		return plateId;
	}

	public void setPlateId(long plateId) {
		this.plateId = plateId;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

}
