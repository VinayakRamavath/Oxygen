package com.example.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class RouteFilter extends ZuulFilter {
	private final static Logger LOGGER = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}


	public boolean shouldFilter() {
		return true;
	}


	public Object run() {
		LOGGER.info("Using Route Filter");

		return null;
	}

}