package com.apps.restspringboot.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	private  static List<User> userList = Stream.of(new User[] { new User(1, "Sam", new Date()),
			new User(2, "Adams", new Date()), new User(3, "Jack", new Date()) }).collect(Collectors.toList());

	public List<User> findAllUsers() {
		return userList;
	}

	public User findUser(Integer id) {

		System.out.println("received userid" + id);
		List<User> matches = userList.stream().filter(user -> (id == user.getId())).collect(Collectors.toList());

		return ((matches.size() > 0) ? matches.get(0) : null);	
	}
	
	public User save(User s) {
		
		System.out.println("inside save.. user.." + s);
		if(s==null )
			return s;
		
		if(s.getId() ==null || s.getId().equals(0))
			s.setId(userList.size()+1);
		
		userList.add(s);
		
		return s;
	}	
	
	public User deleteById(Integer userId) {
		
		Optional<User>  u =  userList.stream().filter(usr->(usr.getId().equals(userId))).findFirst();
		
		if(u.isPresent())
			userList.remove(u);
		
		return u.orElse(null);
		
	}
	
}
