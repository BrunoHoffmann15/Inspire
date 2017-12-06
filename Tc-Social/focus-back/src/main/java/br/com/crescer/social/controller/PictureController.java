/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entity.Picture;
import br.com.crescer.social.entity.model.PictureModel;
import br.com.crescer.social.service.AlbumService;
import br.com.crescer.social.service.PictureService;
import br.com.crescer.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bel
 */
@RestController
@RequestMapping(PictureController.PATH)
public class PictureController {
    
    public static final String PATH = "/picture";
    
    @Autowired
    private PictureService pictureService;
    
    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private PostService postService;
    
    
//    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/new")
    public ResponseEntity postPicture(@RequestBody PictureModel pictureModel) {
        Picture picture = new Picture();
        picture.setUrlImage(pictureModel.getUrl());
        picture.setAlbum(albumService.loadById(pictureModel.getIdAlbum()));
        picture.setPost(postService.loadById(pictureModel.getIdPost()));
        pictureService.postPicture(picture);
        return ResponseEntity.ok(picture);
    }
}
