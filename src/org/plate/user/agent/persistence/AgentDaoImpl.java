package org.plate.user.agent.persistence;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.plate.user.BaseUser;
import org.plate.user.agent.Agent;
import org.plate.user.persistence.BaseUserDaoImpl;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AgentDaoImpl extends BaseUserDaoImpl implements AgentDao{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(AgentDaoImpl.class);
	
	@Override
	public void store(final Agent agent){
		super.store((BaseUser) agent);
	}

	@Override
	public Agent getByEmail(final String email){
		BaseUser bu = super.getByEmail(email);
		return createAgent(bu);
	}

	@Override
	public Agent getById(final UUID id){
		BaseUser bu = (Agent) super.getById(id);
		return createAgent(bu);
	}
	
	private Agent createAgent(BaseUser bu)
	{
		Agent a = new Agent();
		a.copyValues(bu);	
		return a;
	}

	@Override
	public void update(final Agent agent){
		super.update((BaseUser) agent);
	}
	
	
}
