package com.iconos.demo.auth.repository;

import com.iconos.demo.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
    UserEntity findByUsername(String username);
}
