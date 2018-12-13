package org.plate.domain.plate.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.persistence.PlateSellDao;
import org.plate.persistence.PersistenceRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PlateDaoImpl extends NamedParameterJdbcDaoSupport implements PlateDao {
	private static Logger log = Logger.getLogger(PlateDaoImpl.class);
	@Autowired
	private PlateSellDao plateSellDao;
	
	@Override
	public void store(final Plate plate){
		try
		{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO plate "
					+ "(prefix,letter1,letter2,number1,number2,number3,"
					+ "number4,suffix,regNo,digit1,digit2,digit3,"
					+ "digit4,doubledigit,tripledigit,quaddigit,palindromic,paired,rating,listprice) "
					+ "VALUES (?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?)";
			
				getJdbcTemplate().update( new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) 
			        		throws SQLException{
			        	PreparedStatement ps =
				                connection.prepareStatement(sql, new String[] {"id"});
			    	  	ps.setString(1, plate.getPrefix());
						ps.setString(2, plate.getLetter1());
						ps.setString(3, plate.getLetter2());
						ps.setString(4, plate.getNumber1());
						ps.setString(5, plate.getNumber2());
						ps.setString(6, plate.getNumber3());
						ps.setString(7, plate.getNumber4());
						ps.setString(8, plate.getSuffix());
						ps.setString(9, plate.getRegNo());
						ps.setBoolean(10, plate.getDigit1());
						ps.setBoolean(11, plate.getDigit2());
						ps.setBoolean(12, plate.getDigit3());
						ps.setBoolean(13, plate.getDigit4());
						ps.setBoolean(14, plate.getDoubleDigit());
						ps.setBoolean(15, plate.getTripleDigit());
						ps.setBoolean(16, plate.getQuadDigit());
						ps.setBoolean(17, plate.getPalindromic());
						ps.setBoolean(18, plate.getPaired());
						ps.setInt(19, plate.getRating());
						ps.setDouble(20, plate.getListPrice());
						return ps;
			      }
			    },keyHolder);
				
				final long id = keyHolder.getKey().longValue();
				plate.setId(id);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}

	@Override
	public Plate getByRegNo(final String regNo){
		try
		{
			final String sql = "SELECT * FROM plate WHERE regno=?";
			List<Plate> bus = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setString(1, regNo);
				        }
				      }, BeanPropertyRowMapper.newInstance(Plate.class));
			if (bus.isEmpty())
				return null;
			Plate plate = bus.get(0);
			plate.setPlateSell(plateSellDao.getPlateSell(plate));
			return plate;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getByRegNo : " + e.getMessage());
		}
	}

	@Override
	public Plate getById(final long id){
		try
		{
			final String sql = "SELECT * FROM plate WHERE id=?";
			List<Plate> bus = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setLong(1,id);
				        }
				      }, BeanPropertyRowMapper.newInstance(Plate.class));
			if (bus.isEmpty())
				return null;
			Plate plate = bus.get(0);
			plate.setPlateSell(plateSellDao.getPlateSell(plate));
			return plate;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
	

}
