package com.iinur.cat.model;

import com.iinur.cat.data.StateDao;

public class StateModel {

	public void registration(int cat_id, int user_id, String state_name, int val, String unit, String description){
		StateDao sdao = new StateDao();
		sdao.insert(cat_id, user_id, state_name, val, unit, description);
	}
}
