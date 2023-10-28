package spring.cloud.examinator.rest;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ExamController {

    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String, Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(this::getUrl)
                .map(url -> restTemplate.getForObject(url, Question[].class))
                .map(Arrays::asList)
                .map(Section::new)
                .collect(Collectors.toList());

        return new Exam("Exam", sections);
    }

    private String getUrl(Map.Entry<String, Integer> entry) {
        return "http://" + entry.getKey() + "/api/questions?amount=" + entry.getValue();
    }
}
