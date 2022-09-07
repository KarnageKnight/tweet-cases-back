package com.tweet.cases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.cases.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	@Query("SELECT n FROM Comment n WHERE tweet.tweetId=:tweetId")
	List<Comment> findByTweetId(Integer tweetId);
}
