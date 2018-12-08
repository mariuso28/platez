package org.plate.home.persistence;

import org.plate.domain.plate.persistence.PlateDao;
import org.plate.query.persistence.QueryDao;
import org.plate.user.persistence.BaseUserDao;

public interface Home {
	
	public BaseUserDao getBaseUserDao();
	public PlateDao getPlateDao();
	public QueryDao getQueryDao();

}
