package org.plate.domain.plate.sell.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateOffer;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.persistence.PersistenceRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PlateSellDaoImpl extends NamedParameterJdbcDaoSupport implements PlateSellDao {
	private static Logger log = Logger.getLogger(PlateSellDaoImpl.class);

	@Override
	public void storePlateSell(final PlateSell plateSell){
		final Timestamp ts = new Timestamp(plateSell.getSellDate().getTime());
		try
		{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO platesell (plateid,selleremail,selldate) "
					+ "VALUES (?,?,?)";
					
				getJdbcTemplate().update( new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) 
			        		throws SQLException{
			        	PreparedStatement ps =
				                connection.prepareStatement(sql, new String[] {"id"});
			    	  	ps.setLong(1, plateSell.getPlate().getId());
						ps.setString(2, plateSell.getSellerEmail());
						ps.setTimestamp(3,ts);
						return ps;
			      }
			    },keyHolder);
				
				final long id = keyHolder.getKey().longValue();
				plateSell.setId(id);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}
	
	public void deletePlateSell(final PlateSell plateSell){
		try
		{
			final String sql = "DELETE FORM platesell WHERE id = ?";
					
				getJdbcTemplate().update(sql);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}
	
	@Override
	public PlateSell getPlateSell(final Plate plate){
		try
		{
			final String sql = "SELECT * FROM platesell WHERE plateid=?";
			List<PlateSell> pss = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setLong(1,plate.getId());
				        }
				      }, BeanPropertyRowMapper.newInstance(PlateSell.class));
			if (pss.isEmpty())
				return null;
			PlateSell ps = pss.get(0);
			getPlateOffers(ps);
			ps.setPlate(plate);
			return ps;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
	
	public List<PlateSell> getPlateSells(final String sellerEmail){
		try
		{
			final String sql = "SELECT * FROM platesell WHERE sellerEmail=?";
			List<PlateSell> pss = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setString(1,sellerEmail);
				        }
				      }, BeanPropertyRowMapper.newInstance(PlateSell.class));
			for (PlateSell ps : pss)
				getPlateOffers(ps);
			return pss;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
	
	private void getPlateOffers(final PlateSell ps)
	{
		try
		{
			final String sql = "SELECT * FROM plateoffer WHERE platesellid=? ORDER BY offer asc";
			List<PlateOffer> pos = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setLong(1,ps.getId());
				        }
				      }, BeanPropertyRowMapper.newInstance(PlateOffer.class));
			ps.setOffers(pos);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
	
	@Override
	public void storePlateOffer(final PlateOffer plateOffer){
		final Timestamp ts = new Timestamp(plateOffer.getOfferedOn().getTime());
		try
		{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO plateoffer (platesellid,buyeremail,offer,offeredon,status,regno) "
					+ "VALUES (?,?,?,?,?,?)";
					
				getJdbcTemplate().update( new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) 
			        		throws SQLException{
			        	PreparedStatement ps =
				                connection.prepareStatement(sql, new String[] {"id"});
			    	  	ps.setLong(1, plateOffer.getPlateSell().getId());
						ps.setString(2, plateOffer.getBuyerEmail());
						ps.setDouble(3, plateOffer.getOffer());
						ps.setTimestamp(4,ts);
						ps.setString(5, plateOffer.getStatus().name());
						ps.setString(6, plateOffer.getRegNo());
						return ps;
			      }
			    },keyHolder);
				
				final long id = keyHolder.getKey().longValue();
				plateOffer.setId(id);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}

	@Override
	public List<PlateOffer> getPlateOffers(String buyerEmail) {
		try
		{
			final String sql = "SELECT * FROM plateoffer WHERE buyerEmail=? ORDER BY offeredon";
			List<PlateOffer> pos = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setString(1,buyerEmail);
				        }
				      }, BeanPropertyRowMapper.newInstance(PlateOffer.class));
			return pos;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
}
