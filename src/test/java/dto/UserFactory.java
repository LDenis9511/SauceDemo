package dto;

import com.github.javafaker.Faker;

public class UserFactory {
    public static User getUser(){
        Faker faker = new Faker();
        return User.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .zip(faker.address().zipCode())
                .build();
    }
}