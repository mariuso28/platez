package org.plate.user.punter;

import java.util.ArrayList;
import java.util.List;

import org.plate.domain.plate.sell.PlateOffer;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.user.BaseUser;

public class Punter extends BaseUser{
	
	private List<PlateSell> plateSells = new ArrayList<PlateSell>();
	private List<PlateOffer> offers = new ArrayList<PlateOffer>();
	
	public Punter()
	{
		super();
	}

	public List<PlateSell> getPlateSells() {
		return plateSells;
	}

	public void setPlateSells(List<PlateSell> plateSells) {
		this.plateSells = plateSells;
	}

	public List<PlateOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<PlateOffer> offers) {
		this.offers = offers;
	}
	
	
}
