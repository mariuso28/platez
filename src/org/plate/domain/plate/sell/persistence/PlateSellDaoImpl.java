package org.plate.domain.plate.sell.persistence;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.plate.Plate;
import org.plate.domain.plate.sell.PlateOffer;
import org.plate.domain.plate.sell.PlateSell;
import org.plate.json.PlateOfferStatusJson;
import org.plate.persistence.PersistenceRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.codec.Base64;

public class PlateSellDaoImpl extends NamedParameterJdbcDaoSupport implements PlateSellDao {
	private static Logger log = Logger.getLogger(PlateSellDaoImpl.class);

	@Override
	public void storePlateSell(final PlateSell plateSell){
		final Timestamp ts = new Timestamp(plateSell.getSellDate().getTime());
		try
		{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO platesell (plateid,selleremail,selldate,status) "
					+ "VALUES (?,?,?,?)";
					
				getJdbcTemplate().update( new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) 
			        		throws SQLException{
			        	PreparedStatement ps =
				                connection.prepareStatement(sql, new String[] {"id"});
			    	  	ps.setLong(1, plateSell.getPlate().getId());
						ps.setString(2, plateSell.getSellerEmail());
						ps.setTimestamp(3,ts);
						ps.setString(4, plateSell.getStatus().name());
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
	
	@Override
	public void updatePlateSellStatus(final PlateSell plateSell){
	try
		{
			final String sql = "UPDATE platesell SET status=? WHERE id=?";
					
			getJdbcTemplate().update( sql, new PreparedStatementSetter() {
		        public void setValues(PreparedStatement preparedStatement) throws SQLException {
		        	  preparedStatement.setString(1,plateSell.getStatus().name());
			          preparedStatement.setLong(2,plateSell.getId());
			        }
	    });
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}
	
	@Override
	public void updatePlateSellProofOwner(final byte[] bytes,final long plateId){
		try
		{
			final String sql = "UPDATE platesell SET proofowner=? where plateId=?";
					
			getJdbcTemplate().update( sql, new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				        	  preparedStatement.setBytes(1, bytes);
					          preparedStatement.setLong(2,plateId);
					        }
			    });
				
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute updateSellProofOwner : " + e.getMessage());
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
			convertProofOwner(ps);
			ps.setPlate(plate);
			return ps;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}
	
	private void convertProofOwner(PlateSell ps) {
		if (ps.getProofOwner()==null)
		{
			ps.setProofOwnerStr("NO PROOF OF OWNER FOR : " + ps.getSellerEmail());
			return;
		}
		byte[] img = Base64.encode(ps.getProofOwner());
		try {
			ps.setProofOwnerStr(new String(img,"UTF-8"));
			ps.setProofOwner(null);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(),e);
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
			final String sql = "SELECT * FROM plateoffer WHERE platesellid=? "
					+ " AND STATUS <> 'CANCELLED' ORDER BY offer asc";
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
			final String sql = "SELECT * FROM plateoffer WHERE buyerEmail=? AND STATUS <> 'CANCELLED' ORDER BY offeredon";
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

	@Override
	public void setPlateOfferStatus(Long offerId, PlateOfferStatusJson status) {
		final String sql = "UPDATE plateoffer SET status=? WHERE id=?";
		try
		{
			getJdbcTemplate().update( sql, new PreparedStatementSetter() {
				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1,status.name());
					preparedStatement.setLong(2,offerId);
				}
			});

		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	

	}
}
