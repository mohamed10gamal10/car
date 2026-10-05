/*package com.Carrental.car.SErvice;

import com.Carrental.car.Dto.Role;
import com.Carrental.car.Entity.User;
import com.Carrental.car.EntityDto.RegisterDto;
import com.Carrental.car.Repositry.UserRegisterrepositry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRegisterService {
    private final PasswordEncoder passwordEncoder;
    private final UserRegisterrepositry userRegisterrepositry;


    public AuthRegisterService(PasswordEncoder passwordEncoder, UserRegisterrepositry userRegisterrepositry) {
        this.passwordEncoder = passwordEncoder;
        this.userRegisterrepositry = userRegisterrepositry;
    }

    public void Register(RegisterDto registerDto)
    {
        if(userRegisterrepositry.existsByName(registerDto.name()))
        {
            throw new RuntimeException("User is alerady ");
        }
        if (userRegisterrepositry.existsByEmail(registerDto.email()))
        {
            throw new RuntimeException("Email is Found");
        }
        User user=new User();
        user.setName(registerDto.name());
        user.setEmail(registerDto.email());
        user.setPassword(passwordEncoder.encode(registerDto.password()));
        user.setRole(Role.USER);
      userRegisterrepositry.save(user);

    }
}


 */