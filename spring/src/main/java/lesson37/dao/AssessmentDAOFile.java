package lesson37.dao;

import lesson37.dto.Assessment;
import org.springframework.stereotype.Component;

@Component
public class AssessmentDAOFile implements AssessmentDAO {
    @Override
    public Assessment getAssessmentData() {
        return Assessment.builder().id(2L).description("Get data from file system.").build();
    }
}
