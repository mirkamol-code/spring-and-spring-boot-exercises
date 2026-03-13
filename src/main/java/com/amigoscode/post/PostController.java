package com.amigoscode.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: 14 - Create a PostController:
//  - @RestController with @RequestMapping("/api/v1/posts")
//  - Inject PostClient
//  - GET /api/v1/posts — returns all posts from jsonplaceholder
//  - GET /api/v1/posts/{id} — returns a single post
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("")
    public List<Post> getAllPosts() {
        return postClient.getPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postClient.getPostById(id);
    }
}
