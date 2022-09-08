package com.tweet.cases.repository;

import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository to extend Users Table JPA interface
 * @author karnageknight
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * getting user Object if userName exists in USERS table
	 * @param userName
	 * @return User object
	 */
	@Query("SELECT n from User n where userName=:userName")
	User getByName(String userName);

}
