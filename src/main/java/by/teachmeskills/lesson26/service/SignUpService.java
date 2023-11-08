package by.teachmeskills.lesson26.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SignUpService {

    public List<String> getEmptyFields(Map<String, String> fields) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> field : fields.entrySet()) {
            if (!isValid(field.getValue())) {
                result.add(field.getKey());
            }
        }
        return result;
    }

    public boolean isPasswordTheSame(String pswd, String confPswd) {
        return pswd != null && !pswd.isBlank() && pswd.equals(confPswd);
    }

    private boolean isValid(String login) {
        return login != null && !login.isBlank();
    }
}
