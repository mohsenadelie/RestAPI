package com.example.demo.service;

import com.example.demo.domain.Gender;
import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserRequestDTO;
import com.example.demo.domain.dto.UserResponseDTO;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// GIVEN - > Context, WHEN -> Action, THEN -> Result

//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
class UserServiceTest {

    // Field Injection needed for Unit Test
    @Autowired // use in test mode
    private UserService service;

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void beforeEach() {
        repository.deleteAll();
    }

    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }

    @Test
    void createUser() {
        // GIVEN
        UserRequestDTO givenDto = new UserRequestDTO(
                "a",
                "b",
                Gender.MALE,
                LocalDate.of(1990, 01, 01));
        // WHEN
        User actual = service.createUser(givenDto);
        User expected = new User(
                "a",
                "b",
                Gender.MALE,
                LocalDate.of(1990, 01, 01));
        expected.setId(actual.getId());
        // THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllAtFirstTime() {
        // GIVEN
        // Not needed
        // WHEN
        List<User> actual = service.getAll();
        List<User> expected = new ArrayList<>();
        // THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        // GIVEN
        List<User> initialUsers = Arrays.asList(new User(
                        "a",
                        "b",
                        Gender.MALE,
                        LocalDate.of(1990, 01, 01)),
                new User(
                        "c",
                        "d",
                        Gender.FEMALE,
                        LocalDate.of(1995, 01, 01)));
        repository.saveAll(initialUsers);

        // WHEN
        List<User> actual = service.getAll();
        List<User> expected = Arrays.asList(new User(
                        "a",
                        "b",
                        Gender.MALE,
                        LocalDate.of(1990, 01, 01)),
                new User(

                        "c",
                        "d",
                        Gender.FEMALE,
                        LocalDate.of(1995, 01, 01)));
        expected.get(0).setId(actual.get(0).getId());
        expected.get(1).setId(actual.get(1).getId());

        // THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test()
    void getByIdWhenNotFound() {
        // GIVEN
        List<User> initialUsers = Arrays.asList(new User(
                        "a",
                        "b",
                        Gender.MALE,
                        LocalDate.of(1990, 01, 01)),
                new User(
                        "c",
                        "d",
                        Gender.FEMALE,
                        LocalDate.of(1995, 01, 01)));
        repository.saveAll(initialUsers);
        // WHEN
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> service.getById(Long.MAX_VALUE));

        // THEN
        Assertions.assertEquals("not found", exception.getMessage());
    }

    @Test()
    void getById() throws Exception {
        // GIVEN
        List<User> initialUsers = Arrays.asList(new User(
                        "a",
                        "b",
                        Gender.MALE,
                        LocalDate.of(1990, 01, 01)),
                new User(
                        "c",
                        "d",
                        Gender.FEMALE,
                        LocalDate.of(1995, 01, 01)));
        repository.saveAll(initialUsers);
        // WHEN
        UserResponseDTO expected = new UserResponseDTO(
                "a b",
                Gender.MALE,
                LocalDate.of(1990, 01, 01));
        UserResponseDTO actual = service.getById(initialUsers.get(0).getId());
        // THEN
        Assertions.assertEquals(expected, actual);
    }

}