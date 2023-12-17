package by.teachmeskills.lesson26.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

public class SignUpServiceTest {

    @Test
    public void isPasswordTheSame_shouldReturnTrue_withTwoSamePasswords() {
        SignUpService signUpService = new SignUpService();
        assertTrue(signUpService.isPasswordTheSame("123asd", "123asd"));
    }

    @Test
    public void isPasswordTheSame_shouldReturnFalse_withTwoNotSamePasswords() {
        SignUpService signUpService = new SignUpService();
        assertFalse(signUpService.isPasswordTheSame("123", "123asd"));
    }

    @Test
    public void isPasswordTheSame_shouldReturnTrue_withTwoBlankPasswords() {
        SignUpService signUpService = new SignUpService();
        assertFalse(signUpService.isPasswordTheSame("", ""));
    }

    @Test
    public void isPasswordTheSame_shouldReturnTrue_withTwoNulls() {
        SignUpService signUpService = new SignUpService();
        assertFalse(signUpService.isPasswordTheSame(null, null));
    }

    @Test
    public void getEmptyFields_shouldReturnList() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "");
        SignUpService signUpService = new SignUpService();
        assertEquals(List.of("b"), signUpService.getEmptyFields(map));
    }

    @Test
    public void getEmptyFields_shouldReturnEmptyList() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        SignUpService signUpService = new SignUpService();
        assertEquals(emptyList(), signUpService.getEmptyFields(map));
    }
}
