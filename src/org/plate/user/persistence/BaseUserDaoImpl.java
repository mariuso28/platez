package org.plate.user.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.plate.persistence.PersistenceDuplicateKeyException;
import org.plate.persistence.PersistenceRuntimeException;
import org.plate.user.BaseUser;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseUserDaoImpl extends NamedParameterJdbcDaoSupport implements BaseUserDao {
	private static Logger log = Logger.getLogger(BaseUserDaoImpl.class);

	@Override
	public void store(final BaseUser bu) {
		bu.setId(UUID.randomUUID());
		try
		{
			getJdbcTemplate().update("INSERT INTO baseuser (id,email,contact,phone,password,role,enabled) "
										+ "VALUES (?,?,?,?,?,?,false)"
			        , new PreparedStatementSetter() {
						public void setValues(PreparedStatement ps) throws SQLException {
			    	  	ps.setObject(1, bu.getId());
						ps.setString(2, bu.getEmail().toLowerCase());
						ps.setString(3, bu.getContact());
						ps.setString(4, bu.getPhone());
						ps.setString(5, bu.getPassword());
						ps.setString(6, bu.getRole());
			      }
			    });
			
		}
		catch (DuplicateKeyException e)
		{
			log.warn("Could not execute : " + e.getMessage());
			throw new PersistenceDuplicateKeyException("User with email:" + bu.getEmail() + " already exists");
		}	
		catch (DataAccessException e1)
		{
			log.error("Could not execute : " + e1.getMessage(),e1);
			throw new PersistenceRuntimeException("Could not execute store : " + e1.getMessage());
		}	
	}

	@Override
	public BaseUser getByEmail(final String email){
		try
		{
			final String sql = "SELECT * FROM baseUser WHERE email=?";
			List<BaseUser> bus = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setString(1, email);
				        }
				      }, BeanPropertyRowMapper.newInstance(BaseUser.class));
			if (bus.isEmpty())
				return null;
			return bus.get(0);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getByEmail : " + e.getMessage());
		}
	}

	@Override
	public BaseUser getById(final UUID id){
		try
		{
			final String sql = "SELECT * FROM baseUser WHERE id=?";
			List<BaseUser> bus = getJdbcTemplate().query(sql,new PreparedStatementSetter() {
				        public void setValues(PreparedStatement preparedStatement) throws SQLException {
				          preparedStatement.setObject(1, id);
				        }
				      }, BeanPropertyRowMapper.newInstance(BaseUser.class));
			if (bus.isEmpty())
				return null;
			return bus.get(0);
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute getById : " + e.getMessage());
		}
	}

	@Override
	public void update(final BaseUser bu){
		try
		{
			getJdbcTemplate().update("UPDATE baseuser SET contact=?,phone=?,password=?,enabled=? "
										+ "WHERE id=?"
			        , new PreparedStatementSetter() {
						public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, bu.getContact());
						ps.setString(2, bu.getPhone());
						ps.setString(3, bu.getPassword());
						ps.setBoolean(4, bu.isEnabled());
						ps.setObject(5, bu.getId());
			      }
			    });
		}
		catch (DataAccessException e)
		{
			log.error("Could not execute : " + e.getMessage(),e);
			throw new PersistenceRuntimeException("Could not execute update : " + e.getMessage());
		}	
	}

	@Override
	public void setDefaultPasswordForAll(String encoded) {
		String sql = "UPDATE baseuser SET password = '" + encoded + "'";
		try
		{
			log.info(sql);
			getJdbcTemplate().update(sql);
		}
		catch (Exception e)
		{
			log.error("Could not execute : " + sql + " - " + e.getMessage());
		}
	}
	
}
