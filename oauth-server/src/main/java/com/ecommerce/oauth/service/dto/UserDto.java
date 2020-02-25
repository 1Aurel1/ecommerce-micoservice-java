package com.ecommerce.oauth.service.dto;

import com.ecommerce.oauth.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String surname;
    @NotBlank
    private String username;
    @Email
    private String email;

    private String password;

    public UserDto() {
    }

    public UserDto(User user) {
        BeanUtils.copyProperties(this, user);
    }
}
