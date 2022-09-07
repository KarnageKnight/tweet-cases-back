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
	@GetMapping("/getAllTweets")
	public List<Tweet> getAllTweets(){
		return tweetRepository.findAll();
	}

	@GetMapping("/getAllUserTweets")
	public List<Tweet> getAllUserTweets(@RequestParam Integer userId) {
		List<Tweet> allTweets = tweetRepository.findByUserId(userId);
		return allTweets;
	}
	
	@PostMapping("/postTweet")
	public Integer postTweet(@RequestBody Tweet tweet) {
		return tweetRepository.save(tweet).getTweetId();
		
	}
	
	@GetMapping("/getCommentsByTweet")
	public List<Comment> getCommentsByTweet(@RequestParam Integer tweetId){
		return commentRepository.findByTweetId(tweetId);
	}
	
	@PostMapping("/postComment")
	public Integer postComment(@RequestBody Comment comment) {
		return commentRepository.save(comment).getcommentId();
	}
	
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
