/**
 * 
 */
package com.genweb.jbl.rpt.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genweb.jbl.rpt.bean.Utility;
import com.genweb.jbl.rpt.entity.User;
import com.genweb.jbl.rpt.repository.UserRepository;


/**
 * @author iqbal
 *
 */

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByEmail(String email) {
		 return userRepository.findUserByEmail(email);
	}

	@Override
	public void saveUser(@Valid User user) {
		user.setCreatedDate(Utility.getCurrentTimeStamp());
		userRepository.save(user);
		
	}



}
