package com.auth2d.resserver.service;

import java.util.List;

import com.auth2d.resserver.pojo.Comment;
import com.auth2d.resserver.pojo.Post;
import com.auth2d.resserver.pojo.User;

public interface ResourceService {

	User[] getUsers();

	Post[] getPosts();

	Comment[] getComments();

	List<Post> getUserPosts(String userId);
}
