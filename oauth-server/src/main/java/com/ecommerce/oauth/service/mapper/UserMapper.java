package com.ecommerce.oauth.service.mapper;

import com.ecommerce.oauth.model.Authority;
import com.ecommerce.oauth.model.AuthorityName;
import com.ecommerce.oauth.model.User;
import com.ecommerce.oauth.repository.AuthorityRepository;
import com.ecommerce.oauth.service.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private AuthorityRepository authorityRepository;

    @Autowired
    public UserMapper(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public User userDtoTOUser(UserDto userDto){

        User user  = new User();
        BeanUtils.copyProperties(userDto, user);

        Authority authority = authorityRepository.getByName(AuthorityName.USER);

        user.setAuthority(authority);

        return user;
    }
}
