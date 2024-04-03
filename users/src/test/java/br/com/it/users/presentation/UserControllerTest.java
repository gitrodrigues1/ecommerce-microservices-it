package br.com.it.users.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.it.users.domain.dto.UserDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void createUserWithValidDataShouldReturnCreated() {
        //AAA Arrange Act Assert

        UserDto user = Constants.USER;
        ResponseEntity<UserDto> createdUser = restTemplate.postForEntity("/users", user, UserDto.class);
        assertThat(createdUser.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        
    }
    
}
