package br.com.it.users.presentation;

import java.time.LocalDate;

import br.com.it.users.application.dto.UserDto;
import br.com.it.users.domain.model.UserEnum;

public class Constants {
    
    public static final UserDto USER = new UserDto(
        "Adrielson",
        "mail@email.com", 
        LocalDate.of(2000, 01, 01), 
        "123456", 
        UserEnum.ADMIN
    );

    public static final UserDto USER_WITHOUT_NAME = new UserDto(
        "",
        "mail@email.com", 
        LocalDate.of(2000, 01, 01), 
        "123456", 
        UserEnum.ADMIN
    );
}
