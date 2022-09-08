package com.tweet.cases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.Comment;

/**
 * Repository to extend Comments Table JPA interface
 * @author karnageknight
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	/**
	 * getting List of Comment Object where tweet_id is the given parameter
	 * @param tweetId
	 * @return List of Comment object
	 */
	@Query("SELECT n FROM Comment n WHERE tweet.tweetId=:tweetId")
	List<Comment> findByTweetId(Integer tweetId);
}
