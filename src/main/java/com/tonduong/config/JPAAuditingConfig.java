package com.tonduong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JPAAuditingConfig { // kiem tra thay doi neu co thay doi thi tu dong cap nhap modifiledby,...
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	public class AuditorAwareImpl implements AuditorAware<String> {

		@Override
		public String getCurrentAuditor() {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth == null) {
				return null;
			}
			return auth.getName(); //return user name để auditing
		}
	}
}
