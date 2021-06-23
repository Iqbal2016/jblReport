/**
 * 
 */
package com.genweb.jbl.rpt.service;

import javax.validation.Valid;

import com.genweb.jbl.rpt.entity.User;

/**
 * @author iqbal
 *
 */
public interface UserService {

	User findUserByEmail(String email);

	void saveUser(@Valid User user);

}
