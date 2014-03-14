package com.iinur.cat.action;

import com.iinur.cat.model.StateModel;
import com.opensymphony.xwork2.ActionSupport;

public class StateregiAction extends ActionSupport {

	public int ui;//user_id
	public int ci;//cat_id
	public String sn;//state_name
	public int v;//val
	public String u;//unit
	public String d;//description

	public String execute(){
		StateModel smodel = new StateModel();
		smodel.registration(ci, ui, sn, v, u, d);

		return SUCCESS;
	}
}
