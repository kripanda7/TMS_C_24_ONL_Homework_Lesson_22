package lesson37;

import lesson37.config.AppConfig;
import lesson37.service.AssessmentService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class SpringApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AssessmentService assessmentService = context.getBean(AssessmentService.class);
        log.info(assessmentService.getAssessment().toString());
    }
}
