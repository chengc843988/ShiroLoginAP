
package com.tradevan.opass.secu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CorsFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// System.out.println("CORSFilter HTTP Request: " + request.getMethod());

		// Authorize (allow) all domains to consume the content
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
				"GET, OPTIONS, HEAD, PUT, POST");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Accept,content-type,X-Requested-With,Content-Length,Accept-Encoding,X-CSRF-Token,Authorization,token");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");

//		ContainerResponseContext response=(ContainerResponseContext) servletResponse;
//			response.getHeaders().add("Access-Control-Allow-Origin", "*");
//			response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
//			response.getHeaders().add("Access-Control-Allow-Credentials", "true");
//			response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

		
		
		//HttpServletResponse resp = (HttpServletResponse) servletResponse;

		// For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS
		// handshake
		//if (request.getMethod().equals("OPTIONS")) {
		//	resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		//	return;
		//}

		// pass the request along the filter chain
		chain.doFilter(request, servletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
