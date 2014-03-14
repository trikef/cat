package com.iinur.cat.model;

import com.iinur.cat.data.WeightDao;

public class WeightModel {

	public void registration(int cat_id, int user_id, int weight_gram, String description){
		WeightDao wdao = new WeightDao();
		wdao.insert(cat_id, user_id, weight_gram, description);
	}
}
