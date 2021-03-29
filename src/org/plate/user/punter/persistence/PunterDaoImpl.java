package org.plate.user.punter.persistence;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.persistence.PlateDao;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.domain.plate.sell.persistence.PlateSellDao;
import org.plate.user.BaseUser;
import org.plate.user.persistence.BaseUserDaoImpl;
import org.plate.user.punter.Punter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PunterDaoImpl extends BaseUserDaoImpl implements PunterDao{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PunterDaoImpl.class);
	@Autowired
	private PlateDao plateDao;
	@Autowired
	private PlateSellDao plateSellDao;

	@Override
	public void store(final Punter punter){
		super.store((BaseUser) punter);
	}

	@Override
	public Punter getByEmail(final String email){
		BaseUser bu = super.getByEmail(email);
		return createPunter(bu);
	}

	@Override
	public Punter getById(final UUID id){
		BaseUser bu = (Punter) super.getById(id);
		return createPunter(bu);
	}
	
	private Punter createPunter(BaseUser bu)
	{
		Punter p = new Punter();
		p.copyValues(bu);	
		getPlateSells(p);
		p.setOffers(plateSellDao.getPlateOffers(p.getEmail()));
		return p;
	}
	
	private void getPlateSells(Punter punter)
	{
		List<PlateSell> pss = plateSellDao.getPlateSells(punter.getEmail());
		for (PlateSell ps : pss)
		{
			Plate plate = plateDao.getById(ps.getPlateId());
			ps.setPlate(plate);
		}
		punter.setPlateSells(pss);
	}

	@Override
	public void update(final Punter punter){
		super.update((BaseUser) punter);
	}
	
	
}
