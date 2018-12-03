package com.apps.restspringboot.Post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController {

	@Autowired
	PostDAO pdao;

	@GetMapping("/users/{id}/posts")
	public List<Post> getAllPostsByUserId(@PathVariable("id") Integer id) {

		List<Post> posts = pdao.findPostsByUserId(id);

		if (posts == null || posts.isEmpty())
			throw new PostNotFoundException("Error..no posts found for user" + id);

		return posts;
	}

	@GetMapping("/users/{userid}/posts/{entityId}")
	public Post getAllPostsByUserId(@PathVariable("userid") Integer userid,
			@PathVariable("entityId") Integer entityId) {

		Post post = pdao.findPostsByUserIdAndEntityd(userid, entityId);

		if (post == null)
			throw new PostNotFoundException("Error..no post found for user - " + userid + "with post id - " + entityId);

		return post;
	}

	@PostMapping("/users/{id}/posts")

	public ResponseEntity<Object> savePost(@PathVariable("id") Integer userId, @RequestBody Post p) {

		p.setUserId(userId);
		Post savedPost = pdao.save(p);

		// get uri of new entitity. using uribuilder , get current request path, append
		// new elements, substitute with id, and return the new uri

		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("{postid}")
				.buildAndExpand(savedPost.getEntityId()).toUri();

		// return resp entitity with 201 status, and location set to the new uri
		return ResponseEntity.created(uriLocation).body("Post has been created..");

	}
}
