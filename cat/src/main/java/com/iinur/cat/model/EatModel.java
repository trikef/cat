package com.iinur.cat.model;

import java.sql.Timestamp;
import java.util.List;

import com.iinur.cat.data.bean.Eat;
import com.iinur.cat.data.EatDao;

public class EatModel {

	public void registration(int cat_id, int user_id, int food_id, int gram, int state, String description, Timestamp eaten_at){
		EatDao edao = new EatDao();
		edao.insert(cat_id, user_id, food_id, gram, state, description, eaten_at);
	}

	public List<Eat> get(int catId) {
		EatDao edao = new EatDao();
		return edao.get(catId);
	}
}
