package anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anand.entity.PostComment;

@Repository
public interface CommentRepository extends JpaRepository<PostComment, Long> {

}
