package com.roadtrip.bg.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		request.setAttribute("siteName", Config.SITE_NAME);
		request.setAttribute("pageTitle", Config.TITLE_SITE);
		request.setAttribute("metaDescription", Config.META_DESCRIPTION);
		request.setAttribute("metaKeywords", Config.META_KEYWORDS);
		request.setAttribute("year", Config.getYear());
		request.setAttribute("url", Config.SITE_URL);
		request.setAttribute("tplUrl", Config.TPL_URL);
		request.setAttribute("staticUrl", Config.STATIC_URL);
		request.setAttribute("emailAddress", Config.CONTACT_EMAIL);

		filterChain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
