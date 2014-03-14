package com.iinur.cat.data;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;

public class StateDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(StateDao.class);

	public StateDao() {
		super();
	}

	public void insert(int cat_id, int user_id, String state_name, int val, String unit, String description){
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO cat_state ");
		sql.append("(cat_id,user_id,state_name,val,unit,description) ");
		sql.append("VALUES (?,?,?,?,?,?)");

		try {
			run.update(sql.toString(),cat_id,user_id,state_name,val,unit,description);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
