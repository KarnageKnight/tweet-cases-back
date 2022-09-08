package com.tweet.cases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.Tweet;

/**
 * Repository to extend Tweets Table JPA interface
 * @author karnageknight
 *
 */
@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

	/**
	 * getting List of Tweet Object whee user_id is the given parameter
	 * @param userName
	 * @return List of User object
	 */
	@Query("SELECT n FROM Tweet n WHERE userId=:userId")
	List<Tweet> findByUserId(Integer userId);

}
