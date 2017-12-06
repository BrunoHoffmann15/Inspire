/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.component.UserComponent;
import br.com.crescer.social.entity.Album;
import br.com.crescer.social.service.AlbumService;
import br.com.crescer.social.service.PictureService;
import br.com.crescer.social.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(AlbumController.PATH)
public class AlbumController {
    
    public static final String PATH = "/album";
    
     private Pageable pageable = new PageRequest(0, 10);
    
    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private PictureService pictureService;
    
        
    @Autowired
    private UserComponent userComponent;
    
    
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new")
    public void pictureAlbum(@RequestBody Album album) {
        album.setUser(userComponent.loggedUserDetails());
        albumService.postAlbum(album);
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/albuns")
    public ResponseEntity get() {
        List<Album> albuns = albumService.findAll();
        return ResponseEntity.ok(albuns);
    }
    
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/pictures/{id}")
    public ResponseEntity getPosts(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pictureService.findByAlbum(id));
    }
}
