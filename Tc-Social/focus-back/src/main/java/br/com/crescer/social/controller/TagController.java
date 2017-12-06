/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Tag;
import br.com.crescer.social.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bel
 */
@RestController
@RequestMapping(TagController.PATH)
public class TagController {
    
    public static final String PATH = "/tag";
    
    @Autowired
    private TagService tagService;
    
    
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new")
    public ResponseEntity postTag(@RequestBody Tag tag) {
        tagService.postTag(tag);
        return ResponseEntity.ok(tag);
    }
    
}
