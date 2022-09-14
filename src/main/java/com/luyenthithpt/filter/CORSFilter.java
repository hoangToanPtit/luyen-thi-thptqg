package com.luyenthithpt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
// Enable it for Servlet 3.x implementations
@WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class CORSFilter implements Filter {
	

	private static final String[] allowedOrigins = {
          "http://localhost:8080/luyenthithptqg/", "http://127.0.0.1:5500"
	};
	
	public CORSFilter() { 
	}

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		System.out.println("CORSFilter HTTP Request: " + request.getMethod());
		
		String clientURL = request.getHeader("Origin");
//		System.out.println(clientURL);
		
		if(clientURL!=null && isAllowedOrigin(clientURL)) {
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", clientURL);
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
					"GET, OPTIONS, HEAD, PUT, POST, DELETE");
			
			
			// For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS
			// handshake
			HttpServletResponse resp = (HttpServletResponse) servletResponse;
			if (request.getMethod().equals("OPTIONS")) {
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
				return;
			}
		}


		// pass the request along the filter chain
		chain.doFilter(request, servletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	
	private boolean isAllowedOrigin(String origin) {
		for (String allowedOrigin : allowedOrigins) {
			if (origin.contains(allowedOrigin))
				return true;
		}
		return false;
	}

}
