package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
