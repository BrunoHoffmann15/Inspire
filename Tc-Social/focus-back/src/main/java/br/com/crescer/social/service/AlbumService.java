/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Album;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.repository.AlbumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Bel
 */
@Service
public class AlbumService {
    
    @Autowired
    private AlbumRepository albumRepository;

        public List<Album> findByUser(UserEntity user) {            
            return albumRepository.findByUserId(user.getId());            
        }
        
        public List<Album> findAll(){
            return albumRepository.findAll();
        }

	public Album loadById(Long id) {
            return albumRepository.findOne(id);
	}
        
//        public Album loadByName(String name) {
//            return albumRepository.findByAlbumName(name);
//	}
        
        public void postAlbum(Album album) {
            albumRepository.save(album);
        }
        
        public void updateAlbum(Album album) {
            albumRepository.save(album);
        }
        
        public void deleteAlbum(Album album) {
            albumRepository.delete(album);
        }
    
}
