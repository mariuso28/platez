package org.plate.home.persistence;

import org.plate.domain.plate.persistence.PlateDao;
import org.plate.domain.plate.sell.persistence.PlateSellDao;
import org.plate.query.persistence.QueryDao;
import org.plate.user.agent.persistence.AgentDao;
import org.plate.user.persistence.BaseUserDao;
import org.plate.user.punter.persistence.PunterDao;

public interface Home {
	
	public BaseUserDao getBaseUserDao();
	public PlateDao getPlateDao();
	public QueryDao getQueryDao();
	public PunterDao getPunterDao();
	public PlateSellDao getPlateSellDao();
	public AgentDao getAgentDao();

}
