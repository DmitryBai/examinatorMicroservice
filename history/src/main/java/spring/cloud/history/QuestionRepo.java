package spring.cloud.history;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.cloud.history.data.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    
}
