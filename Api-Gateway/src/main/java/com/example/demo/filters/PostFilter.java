package com.example.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {
	private final static Logger LOGGER = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	
	public boolean shouldFilter() {
		return true;
	}


	public Object run() {
		
		LOGGER.info("Using Post Filter");
		

		return null;
	}

}
