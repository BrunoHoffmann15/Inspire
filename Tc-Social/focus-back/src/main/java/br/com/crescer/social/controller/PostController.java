/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Picture;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.service.PictureService;
import br.com.crescer.social.service.PostService;
import br.com.crescer.social.service.TagService;
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
@RequestMapping(PostController.PATH)
public class PostController {
    
    public static final String PATH = "/post";
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private PictureService pictureService;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private UserComponent userComponent;
    
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new")
    public ResponseEntity postPost(@RequestBody Post post) {
        post.setUser(userComponent.loggedUserDetails());
        postService.postPost(post);
        return ResponseEntity.ok(post);
    }
       
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/posts")
    public ResponseEntity getPost() {
        UserEntity user = userComponent.loggedUserDetails();      
        
        return ResponseEntity.ok(postService.findByUserOrUserOrderById(user));
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/pictures/{id}")
    public ResponseEntity getPictures(@PathVariable("id") Long id) {        
        return ResponseEntity.ok(pictureService.findByPostId(id));
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/tags/{id}")
    public ResponseEntity getTags(@PathVariable("id") Long id) {        
        return ResponseEntity.ok(tagService.findByPictureId(id));
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/user-posts")
    public ResponseEntity getPostByUser() {
        UserEntity user = userComponent.loggedUserDetails();      
        
        return ResponseEntity.ok(postService.findByUser(user));
    }
}
