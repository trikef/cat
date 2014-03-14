package com.iinur.cat.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.cat.model.UserinfoModel;
import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({
		@InterceptorRef(value = "cookie", params = { "cookiesName", "cname",
				"cookiesValue", "*" }), @InterceptorRef("defaultStack"), })
public class UserregiAction extends ActionSupport implements CookiesAware,
		ServletResponseAware {

	private static final Logger log = LoggerFactory
			.getLogger(UserregiAction.class);

	private static final String COOKIE_NAME_KEY = "cname";
	private static final String COOKIE_ENC = "Windows-31J";

	public String name;

	public String execute() {
		if (!StringUtils.isEmpty(this.name)) {
			UserinfoModel umodel = new UserinfoModel();
			umodel.registration(this.name);
			try {
				String nameE = this.name;
				nameE = URLEncoder.encode(this.name, COOKIE_ENC);
				Cookie newCookie = new Cookie(COOKIE_NAME_KEY, nameE);
				newCookie.setMaxAge(2 * 360 * 24 * 60 * 60);
				response.addCookie(newCookie);
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage());
			}
		}
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
