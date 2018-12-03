package com.apps.restspringboot.Post;

public class Post {

	private Integer entityId;
	private String post;
	private Integer userId;

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Post(Integer entityId, String post, Integer userId) {
		super();
		this.entityId = entityId;
		this.post = post;
		this.userId = userId;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

}
