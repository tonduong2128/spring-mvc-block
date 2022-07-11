package com.tonduong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tonduong.constaint.SystemConstant;
import com.tonduong.entity.RoleEntity;
import com.tonduong.entity.UserEntity;
import com.tonduong.repository.RoleRepository;
import com.tonduong.repository.UserRepository;

//Chi can load theo user name
@Service
public class CustomerUserDetaislService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;

	// File này sẽ implement UserDetailsService của Spring và định nghĩa cách kiểm
	// tra username , password và quyền của user có hợp lệ hay không Khi user login
	// vào hệ thống ta sẽ query xuống database để kiểm tra user có đúng trong
	// database không và quyền là gì ?
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// đầu tiên mình query xuống database xem có user đó không
		
		
		UserEntity user = userRepository.findOneByUsernameAndStatus(username, SystemConstant.ACTIVE_STATUS)	;
		

		// Nếu không tìm thấy User thì mình thông báo lỗi
		if (user == null) {
			System.out.println("User not found! " + username);
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		
		// Khi đã có user rồi thì mình query xem user đó có những quyền gì (Admin hay
		// User)
		// [ROLE_USER, ROLE_ADMIN,..]
//		List<RoleEntity> roles = roleRepository.findByUsersUsername(user.getUsername());
		List<RoleEntity> roles = user.getRoles();
		
//		System.out.println("Size roles: " + user.getRoles().size());//Khong chay duoc ???
		
		// Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority của spring cho
		// quyền đó
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (RoleEntity role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getCode());
				grantList.add(authority);
			}
		}
		
		// Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp cá thông
		// số như tên , password và quyền
		// Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp
		// Spring Security quản lý được phân quyền như ta đã
		// cấu hình trong bước 4 method configure
		UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);
		return userDetails;
	}
	
}
