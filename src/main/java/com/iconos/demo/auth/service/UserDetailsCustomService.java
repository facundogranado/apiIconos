
package com.iconos.demo.auth.service;

import com.iconos.demo.auth.dto.UserDto;
import com.iconos.demo.auth.entity.UserEntity;
import com.iconos.demo.auth.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    
    //Como ir a buscar el usuario por el nombre cuando llegue 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not fount");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    
    public boolean save(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity = this.userRepository.save(userEntity);
        
        return userEntity != null;
    }
    
}
