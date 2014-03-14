package com.iinur.cat.model;

import java.util.List;

import com.iinur.cat.data.NewsDao;
import com.iinur.cat.data.bean.News;

public class NewsModel {

	public List<News> get(int catId){
		NewsDao ndao = new NewsDao();
		return ndao.get(catId);
	}
}
