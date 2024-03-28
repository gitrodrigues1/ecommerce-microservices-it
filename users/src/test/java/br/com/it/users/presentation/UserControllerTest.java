package br.com.it.users.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import br.com.it.users.domain.dto.CreateUserDto;
import br.com.it.users.domain.dto.GetUserDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserController userController;
    
    @Test
    void createUser_withValidData_shouldReturnCreateUserDto() {
        //ArrangeActAssert
        //Arrange
        var user = new CreateUserDto("Josenófrio", "joseph@yahoo.com", "123456");
        //Act
        var createdUser = restTemplate.postForEntity("/users", user, GetUserDto.class);
        //Assert
        assertThat(createdUser.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(createdUser.getBody().id()).isNotNull();
        assertThat(createdUser.getBody().name()).isEqualTo(user.name());
        assertThat(createdUser.getBody().email()).isEqualTo(user.email());
    }

    @Test
    void createdUser_withInvalidData_shouldReturnBusinessException() throws JSONException {
        
        var createdUser = restTemplate.postForEntity("/users", new JSONObject().put("email", "mail@email.com"), GetUserDto.class);
        assertThat(createdUser.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
