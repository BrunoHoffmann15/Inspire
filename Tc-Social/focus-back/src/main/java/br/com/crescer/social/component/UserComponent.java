/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.component;

import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.entity.model.LoggedUserModel;
import br.com.crescer.social.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bel
 */
@Component
public class UserComponent {
    
    @Autowired
    UserService userService;

    
    private User user() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
    }
    
    public UserEntity loggedUserDetails() {
        return Optional
                .ofNullable(user())
                .map(User::getUsername)
                .map(userService::findByEmail)
                .orElse(null);
    }
    
    public LoggedUserModel loggedUser() {
        return Optional
                .ofNullable(loggedUserDetails())
                .map(LoggedUserModel::convertToLoggedUser)
                .orElse(null);
    }    
    
}
