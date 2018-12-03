package com.apps.restspringboot.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PostDAO {

	private static List<Post> postsList = new ArrayList<Post>();

	public List<Post> findPostsByUserId(Integer userId) {

		List<Post> postsByUserId = postsList.stream().filter(post -> {
			return (post.getUserId().equals(userId));
		}).collect(Collectors.toList());

		return postsByUserId;
	}

	public Post save(Post p) {

		System.out.println("inside save.. post.." + p);
		if (p == null)
			return p;

		if (p.getEntityId() == null || p.getEntityId().equals(0))
			p.setEntityId(postsList.size() + 1);

		postsList.add(p);

		return p;
	}

	public Post findPostsByUserIdAndEntityd(Integer userid, Integer entityId) {
		// TODO Auto-generated method stub

		List<Post> postsFound = postsList.stream().filter(post -> {
			return (post.getUserId().equals(userid) && post.getEntityId().equals(entityId));
		}).collect(Collectors.toList());

		return (postsFound != null && !postsFound.isEmpty()) ? (postsFound.get(0)) : (null);

	}
}
