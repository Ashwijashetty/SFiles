package com.capgemini.ars.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AirlineFilter
 */
@WebFilter("/AirlineFilter")
public class AirlineFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AirlineFilter() {
		// AirlineFilter Constructor
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Destroy method
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// do filter
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// init
	}

}
