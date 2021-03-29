package org.plate.user.agent.persistence;

import java.util.UUID;

import org.plate.user.agent.Agent;

public interface AgentDao {

	public void store(final Agent agent);
	public Agent getByEmail(final String email);
	public Agent getById(final UUID id);
	public void update(final Agent agent);
}
