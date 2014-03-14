package com.iinur.cat.data.bean;

import java.sql.Timestamp;

public class News {

	private int id;
	private int user_id;
	private int food_id;
	private int gram;
	private int state;
	private int weight_gram;//cat_weight
	private String state_name;//cat_state
	private int val;//cat_state
	private String unit;//cat_state
	private String description;
	private Timestamp eaten_at;
	private Timestamp created_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getGram() {
		return gram;
	}
	public void setGram(int gram) {
		this.gram = gram;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getWeight_gram() {
		return weight_gram;
	}
	public void setWeight_gram(int weight_gram) {
		this.weight_gram = weight_gram;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getEaten_at() {
		return eaten_at;
	}
	public void setEaten_at(Timestamp eaten_at) {
		this.eaten_at = eaten_at;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
}
