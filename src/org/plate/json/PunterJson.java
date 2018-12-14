package org.plate.json;

import java.util.Map;

public class PunterJson {
	private ProfileJson profile;
	private Map<String,PlateSellJson> plateSells;
	private Map<String,PlateOfferJson> offers;
	
	public PunterJson()
	{
	}
	
	public ProfileJson getProfile() {
		return profile;
	}

	public void setProfile(ProfileJson profile) {
		this.profile = profile;
	}

	public Map<String,PlateSellJson> getPlateSells() {
		return plateSells;
	}

	public void setPlateSells(Map<String,PlateSellJson> plateSells) {
		this.plateSells = plateSells;
	}

	public Map<String,PlateOfferJson> getOffers() {
		return offers;
	}

	public void setOffers(Map<String,PlateOfferJson> offers) {
		this.offers = offers;
	}
	
	
	
}
