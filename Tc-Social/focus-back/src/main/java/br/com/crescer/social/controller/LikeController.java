/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Like;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.service.LikeService;
import br.com.crescer.social.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bel
 */
@RestController
@RequestMapping(LikeController.PATH)
public class LikeController {
    
    public static final String PATH = "/like";
    
    @Autowired
    private LikeService likeService;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UserComponent userComponent;
    
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new/{id}")
    public ResponseEntity postLike(@PathVariable("id") Long id) {
        UserEntity user = userComponent.loggedUserDetails();
        Like newLike = new Like();
        newLike.setUser(user);
        newLike.setPost(postService.loadById(id));
        Like teste = likeService.findByUserAndPost(newLike);
        if(teste == null)
            likeService.postLike(newLike);
        
        else {
            likeService.deleteLike(teste);
        }      
        
        return ResponseEntity.ok(teste);
    }
    
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/likes/{id}")
    public ResponseEntity getLikes(@PathVariable("id") Long id){
        List<Like> likes = likeService.findByPost(id);
        
        return ResponseEntity.ok(likes);
    }
}
