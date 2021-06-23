/**
 * 
 */
package com.genweb.jbl.rpt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

/**
 * @author iqbal
 *
 */

@Entity
@Table(name = "sys_users")
public class User extends BaseEntity{
	
	@Column(name = "user_name")
	//@UniqueCheck(value = "user_name", enitityName = "User", fieldName = "user_name", message = "*There is already a user with the username provided")
	@NotEmpty(message = "*Please provide an username")
	private String userName;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;

	@Column(name = "full_name")
	@NotEmpty(message = "*Please provide your name")
	private String fullName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ "]";
	}
	
	
	

}
