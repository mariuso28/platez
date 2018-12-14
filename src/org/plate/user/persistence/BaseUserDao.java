package org.plate.user.persistence;

import java.util.UUID;

import org.plate.user.BaseUser;

public interface BaseUserDao {

	public void store(BaseUser bu);
	public void update(BaseUser bu);
	public BaseUser getByEmail(String email);
	public BaseUser getById(UUID id);
	public void setDefaultPasswordForAll(String encoded);
}
