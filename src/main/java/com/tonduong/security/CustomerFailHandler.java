package com.tonduong.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component // handle sucssess auth // authorization //SimpleUrlAuthenticationSuccessHandler
			// | SavedRequestAwareAuthenticationSuccessHandler
public class CustomerFailHandler extends SimpleUrlAuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
//		super.onAuthenticationFailure(request, response, exception);
		
	}
}
