
package com.iconos.demo.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    
    @Email(message = "Username must be an mail")
    private String username;
    @Size(min = 8)
    private String password;
}
