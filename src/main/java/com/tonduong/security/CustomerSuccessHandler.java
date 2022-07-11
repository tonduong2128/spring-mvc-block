package com.tonduong.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.tonduong.constaint.SystemConstant;

@Component // handle sucssess auth // authorization //SimpleUrlAuthenticationSuccessHandler
			// | SavedRequestAwareAuthenticationSuccessHandler
public class CustomerSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
		// TODO Auto-generated method stub
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		GrantedAuthority admin = new SimpleGrantedAuthority("ROLE_" + SystemConstant.ADMIN_CODE);
		GrantedAuthority user = new SimpleGrantedAuthority("ROLE_" + SystemConstant.USER_CODE);

		return authentication.getAuthorities().contains(admin) ? "/admin" : "/";
	}
}
