/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Album;
import br.com.crescer.social.entity.Picture;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.repository.PictureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bel.cogo
 */
@Service
public class PictureService {
    
    @Autowired
	private PictureRepository pictureRepository;

        public List<Picture> findByAlbum(Long id) {
            return pictureRepository.findByAlbumId(id);
        }
        
        public List<Picture> findByPostId(Long id) {
            return pictureRepository.findByPostId(id);
        }
    
	public Page<Picture> list(Pageable pageable) {
            return pictureRepository.findAll(pageable);
	}

	public Picture loadById(Long id) {
            return pictureRepository.findOne(id);
	}
        
        public void postPicture(Picture picture) {
            pictureRepository.save(picture);
        }
        
        public void updatePicture(Picture picture) {
            pictureRepository.save(picture);
        }
        
        public void deletePicture(Picture picture) {
            pictureRepository.delete(picture);
        }

}
