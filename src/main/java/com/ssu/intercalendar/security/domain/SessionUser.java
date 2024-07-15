package com.ssu.intercalendar.security.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SessionUser extends User {

    private com.ssu.intercalendar.user.domain.User user;

    public SessionUser(com.ssu.intercalendar.user.domain.User user){
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }
}
