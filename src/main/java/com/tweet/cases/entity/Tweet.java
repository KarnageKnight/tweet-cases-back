package com.tweet.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="TWEETS")
public class Tweet {
	
	//Used a generator to start value of ID with 2, since ID 1 is already initialize using sql script
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tweetGen")
	@TableGenerator(name="tweetGen",initialValue=1)
	@Column(name = "tweet_id")
	private Integer tweetId;
	
	//Did not create Many to One relation here since login is not need and fully realised and 
	//sending user Object in all tweet related calls to backend would be extra effort(Time constraint) 
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
