package com.tweet.cases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.cases.entity.Comment;
import com.tweet.cases.entity.Tweet;
import com.tweet.cases.entity.User;
import com.tweet.cases.repository.CommentRepository;
import com.tweet.cases.repository.TweetRepository;
import com.tweet.cases.repository.UserRepository;

@RestController
@CrossOrigin
public class TwitterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	/**
	 * Extra work to get and see all tweets
	 * @param userId
	 * @return all tweet list
	 */
	@GetMapping("/getAllTweets") //Unused because of time contraints
	public List<Tweet> getAllTweets(){
		return tweetRepository.findAll();
	}

	/**
	 * Mapping to get tweets for a user
	 * @param userId
	 * @return List of Tweet Objects
	 */
	@GetMapping("/getAllUserTweets")
	public List<Tweet> getAllUserTweets(@RequestParam Integer userId) {
		List<Tweet> allTweets = tweetRepository.findByUserId(userId);
		return allTweets;
	}
	
	/**
	 * Mapping to post a tweet to the web app database
	 * @param tweet Object
	 * @return Tweet_id returned on save
	 */
	@PostMapping("/postTweet")
	public Integer postTweet(@RequestBody Tweet tweet) {
		return tweetRepository.save(tweet).getTweetId();
		
	}
	
	/**
	 * Mapping to get all comments for a tweet
	 * @param tweetId
	 * @return List of Comment objects
	 */
	@GetMapping("/getCommentsByTweet")
	public List<Comment> getCommentsByTweet(@RequestParam Integer tweetId){
		return commentRepository.findByTweetId(tweetId);
	}
	
	/**
	 * Mapping to post a comment for a tweet to the DB
	 * @param comment
	 * @return comment_id returned for a successful save
	 */
	@PostMapping("/postComment")
	public Integer postComment(@RequestBody Comment comment) {
		return commentRepository.save(comment).getcommentId();
	}
	
	/**
	 * Mapping to check if user is present in DB, if present, return the user Id,
	 * If not present, create new user and return user Id
	 * @param userName
	 * @return user Id
	 */
	@GetMapping("/checkUserName")
	public Integer checkUserName(@RequestParam String userName) {
		User loggedInUser = userRepository.getByName(userName);
		if(loggedInUser!=null) return loggedInUser.getUserId();
		else {
			User newUser = new User();
			newUser.setUserName(userName);
			return userRepository.save(newUser).getUserId();
		}
	}
	
}
