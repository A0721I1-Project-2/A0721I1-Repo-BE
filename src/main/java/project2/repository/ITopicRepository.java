package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.model.Topic;

public interface ITopicRepository extends JpaRepository<Topic, Long> {
}
