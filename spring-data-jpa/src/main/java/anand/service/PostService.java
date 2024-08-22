package anand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anand.entity.Post;
import anand.entity.PostComment;
import anand.entity.User;
import anand.repository.CommentRepository;
import anand.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private UserService userService;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	public Post findPostByPostid(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Transactional
	public Post createPost(Post post, Long userId) {
		User user = userService.getUserById(userId);
		if (user == null) {
			throw new IllegalArgumentException("User not found");
		}
		post.setUser(user);
		return postRepository.save(post);
	}

	public Post updatePost(Long postid, Post postDetail) {
		Post post = postRepository.findById(postid).orElse(null);
		if (null != post) {
			post.setTitle(postDetail.getTitle());
			return postRepository.save(post);
		}
		return null;

	}

	@Transactional
	public void deletePost(Long id) {
		if (postRepository.existsById(id)) {
			postRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("User not found");
		}

	}
	
	public List<PostComment> getAllComment(Long postid) {
		return commentRepository.findAll();
	}
}
