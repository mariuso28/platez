package org.plate.home.persistence;

import org.plate.domain.plate.persistence.PlateDao;
import org.plate.domain.plate.sell.persistence.PlateSellDao;
import org.plate.query.persistence.QueryDao;
import org.plate.user.agent.persistence.AgentDao;
import org.plate.user.persistence.BaseUserDao;
import org.plate.user.punter.persistence.PunterDao;

public class HomeImpl implements Home {

	private BaseUserDao baseUserDao;
	private PunterDao punterDao;
	private AgentDao agentDao;
	private PlateDao plateDao;
	private PlateSellDao plateSellDao;
	private QueryDao queryDao;
	
	public HomeImpl()
	{
	}
	
	@Override
	public BaseUserDao getBaseUserDao() {
		return baseUserDao;
	}

	public void setBaseUserDao(BaseUserDao baseUserDao) {
		this.baseUserDao = baseUserDao;
	}

	@Override
	public PunterDao getPunterDao() {
		return punterDao;
	}

	public void setPunterDao(PunterDao punterDao) {
		this.punterDao = punterDao;
	}

	@Override
	public PlateDao getPlateDao() {
		return plateDao;
	}

	public void setPlateDao(PlateDao plateDao) {
		this.plateDao = plateDao;
	}

	@Override
	public QueryDao getQueryDao() {
		return queryDao;
	}

	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	@Override
	public PlateSellDao getPlateSellDao() {
		return plateSellDao;
	}

	public void setPlateSellDao(PlateSellDao plateSellDao) {
		this.plateSellDao = plateSellDao;
	}

	@Override
	public AgentDao getAgentDao() {
		return agentDao;
	}

	public void setAgentDao(AgentDao agentDao) {
		this.agentDao = agentDao;
	}

	
}
