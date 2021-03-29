package org.plate.domain.auction.persistence;

import org.plate.domain.auction.Auction;

public interface AuctionDao {

	public void store(Auction auction);
	public Auction getById(long id);
	public void deleteByRegNo(String regNo);

}
