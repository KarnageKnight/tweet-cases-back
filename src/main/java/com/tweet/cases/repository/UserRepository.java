package com.tweet.cases.repository;

import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT n from User n where userName=:userName")
	User getByName(String userName);

}
