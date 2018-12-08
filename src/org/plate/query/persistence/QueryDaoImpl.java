package org.plate.query.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.query.QueryException;
import org.plate.query.QueryMgr;
import org.plate.query.QueryOnDigitsParams;
import org.plate.query.QueryOnPlateParams;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class QueryDaoImpl extends NamedParameterJdbcDaoSupport implements QueryDao {
	private static Logger log = Logger.getLogger(QueryDaoImpl.class);
	
	private QueryMgr queryMgr = new QueryMgr();
	
	@Override
	public List<Plate> QueryOnPlate(QueryOnPlateParams params) throws PersistenceRuntimeException, QueryException{
		
		log.info("Performing QueryOnPlate with : " + params);
		queryMgr.validate(params);
		String whereStr = buildWhereStr(params);
		if (whereStr.isEmpty())
			throw new QueryException("Query has no parameters");
		String sql = "SELECT * FROM plate WHERE " + whereStr;
		log.info("SQL : " + sql);
		try
		{
			List<Plate> plates = getJdbcTemplate().query(sql, 
					BeanPropertyRowMapper.newInstance(Plate.class));
			return plates;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute QueryOnPlate : " + e.getMessage());
		}
	}

	private String buildWhereStr(QueryOnPlateParams params) {
		String whereStr = "";
		whereStr += addParam(whereStr,"prefix",params.getPrefix());
		whereStr += addParam(whereStr,"letter1",params.getLetter1());
		whereStr += addParam(whereStr,"letter2",params.getLetter2());
		whereStr += addParam(whereStr,"suffix",params.getSuffix());
		whereStr += addParam(whereStr,"number1",params.getNumber1());
		whereStr += addParam(whereStr,"number2",params.getNumber2());
		whereStr += addParam(whereStr,"number3",params.getNumber3());
		whereStr += addParam(whereStr,"number4",params.getNumber4());
		return whereStr;
	}

	private String addParam(String whereStr, String column, String value) {
		if (value.isEmpty())
			return "";
		if (!whereStr.isEmpty())
			return " AND " + column + " = '" + value + "' ";
		return column + " = '" + value + "' ";
	}

	@Override
	public List<Plate> QueryOnDigits(QueryOnDigitsParams params) throws PersistenceRuntimeException {
		log.info("Performing QueryOnDigits with : " + params);
		String whereStr = buildDigitsWhereStr(params);
		
		String sql = "SELECT * FROM plate WHERE " + whereStr;
		log.info("SQL : " + sql);
		try
		{
			List<Plate> plates = getJdbcTemplate().query(sql, 
					BeanPropertyRowMapper.newInstance(Plate.class));
			return plates;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute QueryOnDigits : " + e.getMessage());
		}
	}
	
	private String buildDigitsWhereStr(QueryOnDigitsParams params) {
		String whereStr = "";
		whereStr += addBooleanParam(whereStr,"doubledigit",params.getDoubleDigit());
		whereStr += addBooleanParam(whereStr,"tripledigit",params.getTripleDigit());
		whereStr += addBooleanParam(whereStr,"quaddigit",params.getQuadDigit());
		whereStr += addBooleanParam(whereStr,"paired",params.getPaired());
		whereStr += addBooleanParam(whereStr,"palindromic",params.getPalindromic());

		return whereStr;
	}

	private String addBooleanParam(String whereStr, String column, Boolean value) {
		String clause = " ";
		if (value==null)
			value=false;
		if (!whereStr.isEmpty())
			clause = " AND ";
		if (value)
			clause += column + "= TRUE ";  
		else
			clause += column + "= FALSE ";  
		return clause;
	}
	
	@Override
	public List<Plate> QueryOnListPrice(final double min, final double max) throws PersistenceRuntimeException {
		log.info("Performing QueryOnListPrice with : " + min + " - " + max);
		
		String sql = "SELECT * FROM plate WHERE listprice>=? AND listprice<=?";
		try
		{
			List<Plate> plates = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
		        public void setValues(PreparedStatement preparedStatement) throws SQLException {
			          preparedStatement.setDouble(1,min);
			          preparedStatement.setDouble(2,max);
			        }
			      }, BeanPropertyRowMapper.newInstance(Plate.class));
			return plates;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute QueryOnListPrice : " + e.getMessage());
		}
	}

	@Override
	public List<Plate> QueryOnRating(final int min,final int max) throws PersistenceRuntimeException {
		log.info("Performing QueryOnRating with : " + min + " - " + max);
		
		String sql = "SELECT * FROM plate WHERE rating>=? AND rating<=?";
		try
		{
			List<Plate> plates = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
		        public void setValues(PreparedStatement preparedStatement) throws SQLException {
			          preparedStatement.setInt(1,min);
			          preparedStatement.setInt(2,max);
			        }
			      }, BeanPropertyRowMapper.newInstance(Plate.class));
			return plates;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute QueryOnRating : " + e.getMessage());
		}
	}

	public QueryMgr getQueryMgr() {
		return queryMgr;
	}

	public void setQueryMgr(QueryMgr queryMgr) {
		this.queryMgr = queryMgr;
	}

	

	

}
