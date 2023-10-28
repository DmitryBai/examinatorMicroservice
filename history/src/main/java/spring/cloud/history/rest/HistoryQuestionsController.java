package spring.cloud.history.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.history.QuestionRepo;
import spring.cloud.history.data.Question;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HistoryQuestionsController {

    private final QuestionRepo questionRepo;

    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam int amount) {
        List<Question> questions = questionRepo.findAll();
        Collections.shuffle(questions);

        return questions.stream().limit(amount).collect(Collectors.toList());
    }
}
