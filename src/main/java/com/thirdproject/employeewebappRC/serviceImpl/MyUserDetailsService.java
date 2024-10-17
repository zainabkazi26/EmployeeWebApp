package com.thirdproject.employeewebappRC.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thirdproject.employeewebappRC.entity.Users;
import com.thirdproject.employeewebappRC.repository.UsersRepository;
import com.thirdproject.employeewebappRC.security.MyUserDetails;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UsersRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		return new MyUserDetails(user);
	}

}



