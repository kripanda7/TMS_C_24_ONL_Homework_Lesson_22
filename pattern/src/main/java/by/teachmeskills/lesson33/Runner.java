package by.teachmeskills.lesson33;

import java.util.List;

public class Runner {
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
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));

        User clonedUser = user1.clone();
        System.out.println(user1.equals(clonedUser));
        User deepClonedUser = user1.deepClone();
        System.out.println(user1.equals(deepClonedUser));
        System.out.println(clonedUser.toString());
        System.out.println(deepClonedUser.toString());
    }
}
