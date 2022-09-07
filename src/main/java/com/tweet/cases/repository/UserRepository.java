package com.tweet.cases.repository;

import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
