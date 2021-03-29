package org.plate.domain.plate.persistence;

import org.plate.domain.plate.Plate;

public interface PlateDao {
	public void store(Plate plate);
	public Plate getByRegNo(String regNo);
	public Plate getById(long id);
	public void delete(long id);
}
