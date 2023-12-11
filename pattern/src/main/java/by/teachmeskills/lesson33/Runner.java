package by.teachmeskills.lesson33;

import org.apache.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = User.builder()
                .id(1L)
                .name("John")
                .roles(List.of(Role.builder().id(11L).name("ADMIN").build()))
                .department(Department.builder().id(2L).name("Communication").description("Some decr").build())
                .build();
        User user2 = User.builder()
                .id(1L)
                .name("John")
                .roles(List.of(Role.builder().id(11L).name("ADMIN").build()))
                .department(Department.builder().id(2L).name("Communication").description("Some decr").build())
                .build();
        User user3 = User.builder()
                .id(2L)
                .name("Tom")
                .build();
        LOGGER.info(user1.equals(user2));
        LOGGER.info(user1.equals(user3));

        User clonedUser = user1.clone();
        LOGGER.info(user1.equals(clonedUser));
        User deepClonedUser = user1.deepClone();
        LOGGER.info(user1.equals(deepClonedUser));
        LOGGER.info(clonedUser.toString());
        LOGGER.info(deepClonedUser.toString());
    }
}
