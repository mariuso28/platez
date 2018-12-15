package org.plate.query.persistence;

import java.util.List;

import org.plate.domain.plate.Plate;
import org.plate.json.QueryOnDigitsParamsJson;
import org.plate.json.PlateParamsJson;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.query.QueryException;

public interface QueryDao {
	public List<Plate> QueryOnPlate(PlateParamsJson params) throws PersistenceRuntimeException, QueryException;
	public List<Plate> QueryOnDigits(QueryOnDigitsParamsJson params) throws PersistenceRuntimeException;
	public List<Plate> QueryOnListPrice(double min,double max) throws PersistenceRuntimeException;
	public List<Plate> QueryOnRating(int min,int max) throws PersistenceRuntimeException;
}
