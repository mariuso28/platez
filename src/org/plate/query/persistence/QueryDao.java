package org.plate.query.persistence;

import java.util.List;

import org.plate.domain.plate.Plate;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.query.QueryException;
import org.plate.query.QueryOnDigitsParams;
import org.plate.query.QueryOnPlateParams;

public interface QueryDao {
	public List<Plate> QueryOnPlate(QueryOnPlateParams params) throws PersistenceRuntimeException, QueryException;
	public List<Plate> QueryOnDigits(QueryOnDigitsParams params) throws PersistenceRuntimeException;
	public List<Plate> QueryOnListPrice(double min,double max) throws PersistenceRuntimeException;
	public List<Plate> QueryOnRating(int min,int max) throws PersistenceRuntimeException;
}
