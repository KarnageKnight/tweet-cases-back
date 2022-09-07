package com.tweet.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TWEETS")
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tweet_id")
	private Integer tweetId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="tweet_data")
	private String tweetData;

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTweetData() {
		return tweetData;
	}

	public void setTweetData(String tweetData) {
		this.tweetData = tweetData;
	}
	
	
}
