package org.plate.user.punter.persistence;

import java.util.UUID;

import org.plate.user.punter.Punter;

public interface PunterDao {

	public void store(final Punter punter);
	public Punter getByEmail(final String email);
	public Punter getById(final UUID id);
	public void update(final Punter punter);
}
