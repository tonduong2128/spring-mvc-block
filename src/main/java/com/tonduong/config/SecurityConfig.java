package com.tonduong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.tonduong.constaint.SystemConstant;
import com.tonduong.security.CustomerDeniedHandler;
import com.tonduong.security.CustomerFailHandler;
import com.tonduong.security.CustomerSuccessHandler;
import com.tonduong.service.impl.CustomerUserDetaislService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

	}

	@Autowired
	CustomerSuccessHandler customerSuccessHandler;

	@Autowired
	CustomerDeniedHandler customerDeniedHandler;

	@Autowired
	CustomerFailHandler customerFailHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng
		// quyền chứng thực của người sử dụng đối với 1 website khác
		http.csrf().disable();
		http.cors().disable();
		
		// Các trang không yêu cầu login như vậy ai cũng có thể vào được admin hay user
		// hoặc guest có thể vào các trang
		http.authorizeRequests().antMatchers("/**", "/trang-chu", "/dang-nhap", "/dang-xuat").permitAll();

		// Trang chỉ dành cho ADMIN//phai dat theo thu tu tren xuong
//		http.authorizeRequests().antMatchers("/admin/**").hasAuthority(SystemConstant.ADMIN_CODE); // Sao khong dc
//		http.authorizeRequests().antMatchers("/admin**").hasAuthority("ROLE_" + SystemConstant.ADMIN_CODE); // Sao
																											// khong
																											// dc

		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.sau Mình dung hasAnyRole để
		// cho phép ai được quyền vào
		// 2 ROLE_USER và ROLEADMIN thì ta lấy từ database ra cái mà mình chèn vô ở bước
		// 1 (chuẩn bị database)
//		http.authorizeRequests().antMatchers("/**").hasAnyAuthority(SystemConstant.USER_CODE, SystemConstant.ADMIN_CODE);
//		http.authorizeRequests().antMatchers("/**").hasAnyRole(SystemConstant.USER_CODE, SystemConstant.ADMIN_CODE);

		// hasAuthority: khong tu dong them
		// hasAnyRole: tu dong them "ROLE_" truoc no
		// Khi set role phai co "ROLE" truoc
		// neu khong chi su dung hasAuthority

		// Khi người dùng đã login, với vai trò user .
		// Nhưng cố ý truy cập vào trang admin
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		// Ở đây mình tạo thêm một trang web lỗi tên 403.html (mọi người có thể tạo bất
		// cứ tên nào khi can
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/WEB-INF/views/403.jsp");
//		http.authorizeRequests().and().exceptionHandling().accessDeniedHandler(customerDeniedHandler);
		// Cấu hình cho Login Form.
//		http.authorizeRequests().and().formLogin()//
//				// Submit URL của trang login
//				.loginProcessingUrl("/j_spring_security_check") // Bạn còn nhớ bước 3 khi tạo form login thì action của
//				// nó là j_spring_security_check giống ở
//				.loginPage("/dang-nhap")// url login
////				.defaultSuccessUrl("/")
//				// đây Khi đăng nhập thành công thì vào trang này. userAccountInfo
//				// sẽ được khai báo trong controller để hiển thị trang view
//				// tương ứng
//				.successHandler(customerSuccessHandler) // handle khi sucess auth
////				.failureHandler(customerFailHandler)
//				.failureUrl("/dang-nhap?error=true")// Khi đăng nhập sai username và
//				// password thì nhập lại
//				.usernameParameter("username")// tham số này nhận từ form login ở bước 3 có input name='username'
//				.passwordParameter("password")// tham số này nhận từ form login ở bước 3 có input name='password'
//				// Cấu hình cho Logout Page. Khi logout mình trả về trang
//				.and().logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/dang-xuat=true").
//				// Cấu hình Remember Me. Ở form login bước 3, ta có 1 nút remember me. Nếu người
//				// dùng tick vào đó ta sẽ dùng cookie lưu lại trong 24h
//				and().authorizeRequests().and() //
//				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
//				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); // Ta lưu tạm remember me trong memory
																				// (RAM). Nếu cần mình có thể lưu trong
																				// database
		return memory;
	}

	@Bean // encoding md5
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

//	@Bean // encoding md5
//	public Md5PasswordEncoder passwordEncoder() {
//		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//		return md5PasswordEncoder;
//	}

	@Autowired // ten bien cua spring
	private CustomerUserDetaislService userDetailsService;

	// Method thứ 3 là configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception Trong Spring Security có một object quan trọng đó là
	// UserDetailsService. Đây là object của Spring, nó nắm giữ thông tin quan trọng
	// như Username này là ai trong hệ thống , UserName này có quyền gì.
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// gọi userDetailsService trong bước 5 tiếp theo
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/template/**");
		super.configure(web);
	}
}