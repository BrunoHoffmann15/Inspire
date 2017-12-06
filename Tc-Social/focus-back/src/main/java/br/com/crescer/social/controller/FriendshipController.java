/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Friendship;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.entity.model.FriendshipModel;
import br.com.crescer.social.service.FriendshipService;
import br.com.crescer.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bel
 */
@RestController
@RequestMapping(FriendshipController.PATH)
public class FriendshipController {
    
    public static final String PATH = "/friendship";
    
    @Autowired
    private FriendshipService friendshipService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    UserComponent userComponent;
    
     private Pageable pageable = new PageRequest(0, 10);

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new/{id}")
    public ResponseEntity postFriendship(@PathVariable("id") Long id) {
        Friendship friendship = new Friendship();
        friendship.setFsStatus(false);
        friendship.setUserOne(userComponent.loggedUserDetails());
        friendship.setUserTwo(userService.loadById(id));
        friendshipService.postFriendship(friendship);
        
        return ResponseEntity.ok(friendship);
    }
    
    @Secured("ROLE_ADMIN")
        @GetMapping(path = "/not-friends")
        public ResponseEntity getNotFriends() {
            UserEntity user = userComponent.loggedUserDetails();
            return ResponseEntity.ok(userService.findNotFriends(pageable, user));
        }
        
    @Secured("ROLE_ADMIN")
        @PutMapping(path = "/edited/{id}")
        public ResponseEntity putFriendship(@PathVariable("id") Long id) {
            Friendship friendship = friendshipService.findOneByUsers(id, userComponent.loggedUserDetails().getId());
            friendship.setFsStatus(true);
            friendshipService.updateFriendship(friendship);
            return ResponseEntity.ok(friendship);
        }
        
    @Secured("ROLE_ADMIN")
        @GetMapping(path = "/solicitations")
        public ResponseEntity getSolicitations() {
            UserEntity user = userComponent.loggedUserDetails();
            
            return ResponseEntity.ok(friendshipService.listSolicitations(pageable, user));
                    
        }
        
    @Secured("ROLE_ADMIN")
        @GetMapping(path = "/friends")
        public ResponseEntity getFriends() {
            UserEntity user = userComponent.loggedUserDetails();
            
            return ResponseEntity.ok(friendshipService.findByUserOne(pageable, user));
                    
        }
    
}
