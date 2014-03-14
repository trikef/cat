package com.iinur.cat.data;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.cat.data.bean.Eat;
import com.iinur.core.data.BaseDao;

public class EatDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(EatDao.class);

	public EatDao() {
		super();
	}

	public List<Eat> get(int catId) {
		String sql = "SELECT * FROM eat Where cat_id=? ORDER BY eaten_at DESC";
		List<Eat> es = null;
		try {
			ResultSetHandler<List<Eat>> rsh = new BeanListHandler<Eat>(Eat.class);
			es = run.query(sql, rsh, catId);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return es;
	}

	public void insert(int cat_id, int user_id, int food_id, int gram, int state, String description, Timestamp eaten_at){
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO eat ");
		sql.append("(cat_id,user_id,food_id,gram,state,description,eaten_at) ");
		sql.append("VALUES (?,?,?,?,?,?,?)");

		try {
			run.update(sql.toString(),cat_id,user_id,food_id,gram,state,description,eaten_at);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}

	public void updateGram(int id, int gram) {
		String sql = "UPDATE eat SET gram =? WHERE id =?";
		try {
			run.update(sql,gram,id);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
	}
}
