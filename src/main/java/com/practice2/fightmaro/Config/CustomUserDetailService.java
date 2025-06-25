package com.practice2.fightmaro.Config;

import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Repositories.UserRepo;
import com.practice2.fightmaro.Entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user=this.userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("user Not found"));

        return user;
    }

}
