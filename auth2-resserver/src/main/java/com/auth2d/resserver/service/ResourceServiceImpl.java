package com.auth2d.resserver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auth2d.resserver.pojo.Comment;
import com.auth2d.resserver.pojo.Post;
import com.auth2d.resserver.pojo.User;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private RestTemplate restTemplate;

	public User[] getUsers() {
		return restTemplate.getForObject("https://gorest.co.in/public/v2/users", User[].class);
	}

	@Override
	public Post[] getPosts() {
		return restTemplate.getForObject("https://gorest.co.in/public/v2/posts", Post[].class);
	}

	@Override
	public Comment[] getComments() {
		return restTemplate.getForObject("https://gorest.co.in/public/v2/comments", Comment[].class);
	}

	@Override
	public List<Post> getUserPosts(String userId) {
		Post[] posts = restTemplate.getForObject("https://gorest.co.in/public/v2/posts", Post[].class);
		List<Post> userPosts = java.util.Arrays.stream(posts).filter(post -> post.getUser_id().equals(userId))
				.collect(Collectors.toList());
		return userPosts;
	}
}
