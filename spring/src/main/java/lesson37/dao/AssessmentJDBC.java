package lesson37.dao;

import lesson37.dto.Assessment;
import org.springframework.stereotype.Component;

@Component
public class AssessmentJDBC implements AssessmentDAO {
    @Override
    public Assessment getAssessmentData() {
        return Assessment.builder().id(4L).description("Get data from DB.").build();
    }
}
