package org.plate.domain.plate.sell.persistence;

import java.util.List;

import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateOffer;
import org.plate.domain.plate.sell.PlateSell;

public interface PlateSellDao {
	public void storePlateSell(final PlateSell plateSell);
	public void deletePlateSell(final PlateSell plateSell);
	public List<PlateSell> getPlateSells(final String sellerEmail);
	public void storePlateOffer(PlateOffer plateOffer);
	public PlateSell getPlateSell(Plate plate);
	public List<PlateOffer> getPlateOffers(String email);
}
