package com.iinur.cat.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import com.iinur.cat.model.EatModel;
import com.opensymphony.xwork2.ActionSupport;

public class EatregiAction extends ActionSupport{

	public int ui;//user_id
	public int ci;//cat_id
	public int fi;//food_id
	public int g;//gram
	public int s;//state
	public String d;//description
	public int eah;//eaten_at
	public int eam;//eaten_at

	public String execute(){
		EatModel emodel = new EatModel();
		Calendar now = Calendar.getInstance();
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), eah, eam);
		emodel.registration(ci, ui, fi, g, s, d, new Timestamp(now.getTimeInMillis()));
		return SUCCESS;
	}
}
