package spring.cloud.math.service;

import org.springframework.stereotype.Service;
import spring.cloud.math.rest.Question;

import java.util.Random;

@Service
public class MathService {
    private Random random = new Random();
    private int max = 10;

    public Question getRandom() {
        int a = random.nextInt(max);
        int b = random.nextInt(max);

        return Question.builder().question(a + " + " + b + " = ?").answer(String.valueOf(a + b)).build();
    }
}
