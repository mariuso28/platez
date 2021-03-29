package org.plate.domain.auction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.plate.domain.plate.Plate;

public class Auction implements Serializable{

	private static final long serialVersionUID = 2051762105428394292L;
	private long id;
	private long plateId;
	private Plate plate;
	private AuctionState state;
	private Date openDate;
	private Date closeDate;
	private double reservePrice;
	private double firstBid;
	private double bidIncrement;
	private List<Bid> bids;
	
	public Auction()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlateId() {
		return plateId;
	}

	public void setPlateId(long plateId) {
		this.plateId = plateId;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public AuctionState getState() {
		return state;
	}

	public void setState(AuctionState state) {
		this.state = state;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public double getFirstBid() {
		return firstBid;
	}

	public void setFirstBid(double firstBid) {
		this.firstBid = firstBid;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
