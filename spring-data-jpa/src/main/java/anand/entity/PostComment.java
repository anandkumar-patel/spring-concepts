package anand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "post_comment")
public class PostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
	private String review;

	public Long getId() {
		return id;
	}

	public PostComment setId(Long id) {
		this.id = id;
		return this;
	}

	public Post getPost() {
		return post;
	}

	public PostComment setPost(Post post) {
		this.post = post;
		return this;
	}

	public String getReview() {
		return review;
	}

	public PostComment setReview(String review) {
		this.review = review;
		return this;
	}

}