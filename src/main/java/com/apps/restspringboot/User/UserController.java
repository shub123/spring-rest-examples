
package com.apps.restspringboot.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	UserDAO dao;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return dao.findAllUsers();

	}

	@GetMapping("/users/{id}")
	// handle notfound- by throwing a 404 error
	public Resource<User> getUser(@PathVariable Integer id) {
		User u = dao.findUser(id);

		if (u == null)
			throw new UserNotFoundException("User " + id + " is not found..");

		// HATEOAS enabled link discovery

		Resource<User> resource = new Resource<User>(u);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}	

	@DeleteMapping("/users/{id}")
	// handle notfound- by throwing a 404 error
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		User u = dao.deleteById(id);

		if (u == null)
			throw new UserNotFoundException("User " + id + " is not found.. Couldnt be deleted..");

		return ResponseEntity.ok().body("User" + id + " has been deleted successfully..");

	}

	@PostMapping("/users")

	// return status, uri of created resources as well

	public ResponseEntity<Object> save(@Valid @RequestBody User s) {

		User savedUser = dao.save(s);

		// get uri of new entitity. using uribuilder , get current request path, append
		// new elements, substitute with id, and return the new uri

		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		// return resp entitity with 201 status, and location set to the new uri
		return ResponseEntity.created(uriLocation).body("Entity has been created..");

	}

}
