package spring.cloud.math.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.math.service.MathService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping("/questions")
    public List<Question> getRandomQuestions(@RequestParam int amount) {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandom());
        }

        return questions;
    }
}
