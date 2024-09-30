package com.example.monolithic_spring_security.service;

import com.example.monolithic_spring_security.dao.AuthUserDao;
import com.example.monolithic_spring_security.entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AuthUserDao authUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = authUserDao.findByAuthUserName(username);
        return authUser
                .map((userInfo) -> new CustomUserDetails(userInfo.getAuthUserName(), userInfo.getAuthUserPwd(), userInfo.getAllRoles()))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
