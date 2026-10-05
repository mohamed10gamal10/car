package com.Carrental.car.SErvice;

import com.Carrental.car.Repositry.Userrepositry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class userdetailsservice implements UserDetailsService {
    private  final Userrepositry userrepositry;

    public userdetailsservice(Userrepositry userrepositry) {
        this.userrepositry = userrepositry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=
                userrepositry.findByName(username);
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}


