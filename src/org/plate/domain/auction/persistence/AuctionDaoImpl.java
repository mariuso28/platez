package org.plate.domain.auction.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.plate.domain.auction.Auction;
import org.plate.domain.auction.Bid;
import org.plate.persistence.PersistenceRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AuctionDaoImpl extends NamedParameterJdbcDaoSupport implements AuctionDao {
	private static Logger log = Logger.getLogger(AuctionDaoImpl.class);
	
	@Override
	public void store(final Auction auction){
		try
		{
			final Timestamp ts1 = new Timestamp(auction.getOpenDate().getTime());
			final Timestamp ts2 = new Timestamp(auction.getCloseDate().getTime());
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO auction "
					+ "(plateid,state,opendate,closedate,reserveprice,firstbid,bidincrement) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
				getJdbcTemplate().update( new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) 
			        		throws SQLException{
			        	PreparedStatement ps =
				                connection.prepareStatement(sql, new String[] {"id"});
			    	  	ps.setLong(1, auction.getPlate().getId());
						ps.setString(2, auction.getState().name());
						ps.setTimestamp(3, ts1);
						ps.setTimestamp(4, ts2);
						ps.setDouble(5, auction.getReservePrice());
						ps.setDouble(6, auction.getFirstBid());
						ps.setDouble(7, auction.getBidIncrement());
						return ps;
			      }
			    },keyHolder);
				
				final long id = keyHolder.getKey().longValue();
				auction.setId(id);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute store : " + e.getMessage());
		}	
	}
	
	@Override
	public Auction getById(final long id){
		try
		{
			final String sql = "SELECT * FROM auction WHERE id=?";
			List<Auction> as = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setLong(1,id);
				        }
				      }, BeanPropertyRowMapper.newInstance(Auction.class));
			if (as.isEmpty())
				return null;
			Auction auction = as.get(0);
			auction.setBids(getBids(auction.getId()));
			return auction;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}

	private List<Bid> getBids(long id) {
		try
		{
			final String sql = "SELECT * FROM bid WHERE auctionid=?";
			List<Bid> bids = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setLong(1,id);
				        }
				      }, BeanPropertyRowMapper.newInstance(Bid.class));
			return bids;
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}

	@Override
	public void deleteByRegNo(final String regNo) {
		try
		{
			final String sql = "DELETE * FROM auction WHERE plateid=(SELECT id FROM plate WHERE regno = ?";
			getJdbcTemplate().update(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setString(1,regNo);
				        }
				      });
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute deleteByRegNo : " + e.getMessage());
		}
	}
	
}
