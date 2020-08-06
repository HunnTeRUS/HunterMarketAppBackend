package com.hunter.cursomc.services;

import com.hunter.cursomc.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserServices {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
