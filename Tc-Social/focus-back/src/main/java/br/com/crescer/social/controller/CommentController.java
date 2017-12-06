/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Comment;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.service.CommentService;
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
@RequestMapping(CommentController.PATH)
public class CommentController {
    
    public static final String PATH = "/comment";
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserComponent userComponent;
    
    @Autowired
    private PostService postService;
    
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new")
    public ResponseEntity postComment(@RequestBody Comment comment) {
        UserEntity user = userComponent.loggedUserDetails();
        comment.setUser(user);

        commentService.postComment(comment);
       
        return ResponseEntity.ok(comment);
    }
    
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/comments/{id}")
    public ResponseEntity getComments(@PathVariable("id") Long id){
        List<Comment> comments = commentService.findByPost(id);
        
        return ResponseEntity.ok(comments);
    }
    
}
