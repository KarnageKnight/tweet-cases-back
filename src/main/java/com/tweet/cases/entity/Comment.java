package com.tweet.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="COMMENTS")
public class Comment {
	
	//Used a generator to start value of ID with 2, since ID 1 is already initialize using sql script
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "commentGen") 
	@TableGenerator(name="commentGen",initialValue=1)
	@Column(name = "comment_id")
	private Integer commentId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	//Many to One relation with tweet, since one tweet can have many comments, 
	//fetch type is set as eager as we need to return a tweet object for posting a comment 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tweet_id")
	private Tweet tweet;
	
	@Column(name="comment_data")
	private String commentData;

	public Integer getcommentId() {
		return commentId;
	}

	public void setcommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public String getCommentData() {
		return commentData;
	}

	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", tweet=" + tweet + ", commentData="
				+ commentData + "]";
	}
	
	
}
