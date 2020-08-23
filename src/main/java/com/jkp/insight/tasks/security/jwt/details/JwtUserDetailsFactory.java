package com.jkp.insight.tasks.security.jwt.details;

import com.jkp.insight.tasks.model.entity.Role;
import com.jkp.insight.tasks.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserDetailsFactory {
    public JwtUserDetailsFactory() {
    }
    public static JwtUserDetails  create(User user) {
        return JwtUserDetails.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .enable(true)
                .authorities(mapToGrantedAuthority())
                .build();

    }

    private static List<GrantedAuthority> mapToGrantedAuthority() {
        return Arrays.asList("USER","ADMIN").stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
        /*
        List<Role> roleList = new ArrayList<Role>();
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).
                collect(Collectors.toList());*/
    }
}
