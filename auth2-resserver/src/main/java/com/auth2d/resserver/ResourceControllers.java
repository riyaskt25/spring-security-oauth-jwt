package com.auth2d.resserver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.auth2d.resserver.pojo.Comment;
import com.auth2d.resserver.pojo.Post;
import com.auth2d.resserver.pojo.User;
import com.auth2d.resserver.service.ResourceService;

@RestController
public class ResourceControllers {

	@Autowired
	private ResourceService userService;

	@GetMapping("/users")
	public ResponseEntity<?> getUsers() throws Exception {
		try {
			User[] users = userService.getUsers();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error While processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/posts")
	public ResponseEntity<?> getPosts() throws Exception {
		try {
			Post[] Posts = userService.getPosts();
			return new ResponseEntity<>(Posts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error While processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/comments")
	public ResponseEntity<?> getComments() throws Exception {
		try {
			Comment[] comments = userService.getComments();
			return new ResponseEntity<>(comments, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error While processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/posts/{userId}")
	public ResponseEntity<?> getUserPosts(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String userId) throws Exception {
		try {
			List<Post> userPosts = userService.getUserPosts(userId);
			return new ResponseEntity<>(userPosts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error While processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
