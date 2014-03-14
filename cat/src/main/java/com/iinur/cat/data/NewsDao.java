package com.iinur.cat.data;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.cat.data.bean.News;
import com.iinur.core.data.BaseDao;

public class NewsDao extends BaseDao{
	private static final Logger log = LoggerFactory.getLogger(NewsDao.class);

	public NewsDao() {
		super();
	}

	public List<News> get(int catId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM ( ");
		sql.append("SELECT e.id,e.cat_id,e.user_id,e.food_id,e.gram,e.state,null as state_name,0 as val,null as unit,e.description,e.eaten_at,e.eaten_at as created_at,0 as weight_gram FROM eat e Where cat_id=? ");
		sql.append("UNION ");
		sql.append("SELECT s.id,s.cat_id,s.user_id,0 as food_id,0 as gram,0 as state,s.state_name,val,unit,s.description,null as eaten_at,s.created_at,0 as weight_gram FROM cat_state s Where cat_id=? ");
		sql.append("UNION ");
		sql.append("SELECT w.id,w.cat_id,w.user_id,0 as food_id,0 as gram,0 as state,null as state_name,0 as val,null as unit,w.description,null as eaten_at,w.created_at,w.weight_gram FROM cat_weight w Where cat_id=? ");
		sql.append(") un ");
		sql.append("ORDER BY created_at DESC");

		List<News> ns = null;
		try {
			ResultSetHandler<List<News>> rsh = new BeanListHandler<News>(News.class);
			ns = run.query(sql.toString(), rsh, catId,catId,catId);
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			throw new RuntimeException(sqle.toString());
		}
		return ns;
	}
}
