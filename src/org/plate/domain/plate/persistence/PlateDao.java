package org.plate.domain.plate.persistence;

import org.plate.domain.plate.Plate;
import org.plate.persistence.PersistenceRuntimeException;

public interface PlateDao {
	public void store(Plate plate) throws PersistenceRuntimeException;
	public Plate getByRegNo(String regNo) throws PersistenceRuntimeException;
	public Plate getById(long id) throws PersistenceRuntimeException;
}
