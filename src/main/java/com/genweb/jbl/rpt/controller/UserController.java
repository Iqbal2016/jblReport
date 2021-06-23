/**
 * 
 */
package com.genweb.jbl.rpt.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.genweb.jbl.rpt.entity.User;
import com.genweb.jbl.rpt.service.UserService;


/**
 * @author iqbal
 *
 */

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private UserRepository userRepository;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView viewPage() {

		return new ModelAndView("user/registration");
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		logger.info(".......userExists...."+userExists);
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("user/registration");
		} else {
			logger.info(".............user..."+user+"...."+user.getEmail()+"...."+user.getFullName());
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("user/registration");
			
		}
		return modelAndView;
	}

}
