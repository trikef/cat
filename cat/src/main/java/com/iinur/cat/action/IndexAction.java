package com.iinur.cat.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.cat.model.EatModel;
import com.iinur.cat.data.bean.Eat;
import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({
	  @InterceptorRef(value="cookie" ,
	      params={"cookiesName", "cname" ,
	          "cookiesValue" , "*"}),
	  @InterceptorRef("defaultStack"),})
@Results({
	  @Result(name="input", location="userinput.jsp")
	})
public class IndexAction extends ActionSupport implements CookiesAware, ServletResponseAware{

	private static final Logger log = LoggerFactory.getLogger(IndexAction.class);

	private static final String COOKIE_NAME_KEY = "cname";
	private static final String COOKIE_ENC = "Windows-31J";

	public String name;
	
	private List<Eat> es;

	public List<Eat> getEs() {
		return es;
	}


	public void setEs(List<Eat> es) {
		this.es = es;
	}


	public String execute(){
		
		try {
			if (cookie.containsKey(COOKIE_NAME_KEY)) {

				this.name = URLDecoder.decode(
						cookie.get(COOKIE_NAME_KEY), COOKIE_ENC);

			} else {
				return INPUT;
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}

		EatModel emodel = new EatModel();
		this.es = emodel.get(1);
		return SUCCESS;
	}
	
	private HttpServletResponse response;
	private Map<String, String> cookie;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookie = cookies;
	}
	
	/*
	 * cookie hunter name
	 */
	private String cname;

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}
}