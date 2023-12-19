package lesson37.service;

import lesson37.dao.AssessmentDAO;
import lesson37.dto.Assessment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {
    private final AssessmentDAO assessmentDAO;
    private final ValidationService validationService;

    public AssessmentService(@Qualifier("assessmentJDBC") AssessmentDAO assessmentDAO, ValidationService validationService) {
        this.assessmentDAO = assessmentDAO;
        this.validationService = validationService;
    }

    public Assessment getAssessment() {
        Assessment assessment = assessmentDAO.getAssessmentData();
        if (validationService.isValid(assessment.getId())) {
            return assessment;
        }
        return Assessment.builder().build();
    }
}
