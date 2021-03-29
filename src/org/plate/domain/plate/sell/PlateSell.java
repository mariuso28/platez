package org.plate.domain.plate.sell;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.plate.domain.plate.Plate;
import org.plate.json.PlateSellStatusJson;

public class PlateSell {
	private long id;
	private long plateId;
	private Plate plate;
	private String sellerEmail;
	private Date sellDate;
	private List<PlateOffer> offers = new ArrayList<PlateOffer>();
	private String proofOwnerStr;
	private byte[] proofOwner;
	private PlateSellStatusJson status;
	
	public PlateSell()
	{
	}

	public String getPlateSellProofOwnerDocName()
	{
		return plate.getRegNo() + sellerEmail + ".zzz";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
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

	public List<PlateOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<PlateOffer> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "PlateSell [id=" + id + ", plate=" + plate.getRegNo() + ", sellerEmail=" + sellerEmail + ", sellDate=" + sellDate
				+ ", offers=" + offers + "]";
	}

	public long getPlateId() {
		return plateId;
	}

	public void setPlateId(long plateId) {
		this.plateId = plateId;
	}

	

	public String getProofOwnerStr() {
		return proofOwnerStr;
	}

	public void setProofOwnerStr(String proofOwnerStr) {
		this.proofOwnerStr = proofOwnerStr;
	}

	public byte[] getProofOwner() {
		return proofOwner;
	}

	public void setProofOwner(byte[] proofOwner) {
		this.proofOwner = proofOwner;
	}

	public PlateSellStatusJson getStatus() {
		return status;
	}

	public void setStatus(PlateSellStatusJson status) {
		this.status = status;
	}
	
	

}
