package anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anand.entity.Post;
import anand.entity.PostComment;
import anand.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> getAllPost() {
		List<Post> posts = postService.getAllPost();
		if(posts.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(posts);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findPostByPostid(@PathVariable Long id) {
		Post post = postService.findPostByPostid(id);
		if(null != post) {
			return ResponseEntity.ok(post);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post, @RequestParam Long userId) {
		Post createdPost = postService.createPost(post, userId);
		return ResponseEntity.ok(createdPost);
	}

	@PutMapping("/{postid}")
	public ResponseEntity<Post> updatePost(@PathVariable Long postid, @RequestBody Post postDetail) {
		Post updatedPost = postService.updatePost(postid, postDetail);
		if(null != updatedPost) {
			return ResponseEntity.ok(updatedPost);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{postid}")
	public ResponseEntity<Void> deletePost(@PathVariable Long postid) {
		try {
			postService.deletePost(postid);
			return ResponseEntity.noContent().build(); // 204 No Content
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404 Not Found
		}
	}

	@GetMapping("/{postid}/comments")
	public ResponseEntity<List<PostComment>> getAllComment(@PathVariable Long postid) {
		return ResponseEntity.ok(postService.getAllComment(postid));
	}

}
