package com.iinur.cat.data;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.data.BaseDao;

public class WeightDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(WeightDao.class);

	public WeightDao() {
		super();
	}

	public void insert(int cat_id, int user_id, int weight_gram, String description){
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO cat_weight ");
		sql.append("(cat_id,user_id,weight_gram,description) ");
		sql.append("VALUES (?,?,?,?)");

		try {
			run.update(sql.toString(),cat_id,user_id,weight_gram,description);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
