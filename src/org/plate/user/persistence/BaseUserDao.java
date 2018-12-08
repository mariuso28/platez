package org.plate.user.persistence;

import java.util.UUID;

import org.plate.persistence.PersistenceRuntimeException;
import org.plate.user.BaseUser;

public interface BaseUserDao {

	public void store(BaseUser bu) throws PersistenceRuntimeException;
	public void update(BaseUser bu) throws PersistenceRuntimeException;
	public BaseUser getByEmail(String email) throws PersistenceRuntimeException;
	public BaseUser getById(UUID id) throws PersistenceRuntimeException;
}
