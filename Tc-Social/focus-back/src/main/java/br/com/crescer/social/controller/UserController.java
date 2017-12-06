/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Album;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.service.AlbumService;
import br.com.crescer.social.service.FriendshipService;
import br.com.crescer.social.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bel.cogo
 */
@RestController
@RequestMapping(UserController.PATH)
public class UserController {
    
    public static final String PATH = "/user";
    
    private Pageable pageable = new PageRequest(0, 10);
    
    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private FriendshipService friendshipService;
    
    @Autowired
    private UserComponent userComponent;
    
//    @Secured("ROLE_ADMIN")
	@GetMapping
	public UserDetails getUser(Authentication authentication) {
		return (UserDetails) authentication.getPrincipal();
	}
        
//    @Secured("ROLE_ADMIN")
	@GetMapping(path = "/albuns")
	public List<Album> getAlbuns() {
            UserEntity user = userComponent.loggedUserDetails();
		return albumService.findByUser(user);
	}
        
        @GetMapping(path = "/{id}")
        public ResponseEntity getUserById(@PathVariable("id") Long id) {
            return ResponseEntity.ok(userService.loadById(id));
        }
        
        @PostMapping(path = "/new")
        public void postUser(@RequestBody UserEntity user) {
            userService.postUser(user);
        }
//    @Secured("ROLE_ADMIN")  
        @PutMapping(path = "/edited")
        public void updateUser(@RequestBody UserEntity user) {
            userService.updateUser(user);
        }
//    @Secured("ROLE_ADMIN")    
        @DeleteMapping(path = "/deleted")
        public void deleteUser(@Valid @RequestBody UserEntity user) {
            userService.deleteUser(user);
        }
        
//    @Secured("ROLE_ADMIN")
        @GetMapping(path = "/current")
        public ResponseEntity getCurr() {
            return ResponseEntity.ok(userComponent.loggedUserDetails());
        }
           
    
}
