package com.iinur.cat.action;

import com.iinur.cat.model.WeightModel;
import com.opensymphony.xwork2.ActionSupport;

public class WeightregiAction extends ActionSupport {

	public int ui;//user_id
	public int ci;//cat_id
	public int w;//weight_gram
	public String d;//description

	public String execute(){
		WeightModel wmodel = new WeightModel();
		wmodel.registration(ci, ui, w, d);

		return SUCCESS;
	}
}
