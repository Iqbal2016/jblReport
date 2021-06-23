/**
 * 
 */
package com.genweb.jbl.rpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.genweb.jbl.rpt.entity.User;

/**
 * @author iqbal
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select model from User model where model.email=:email")
	User findUserByEmail(@Param("email") String email);

}
