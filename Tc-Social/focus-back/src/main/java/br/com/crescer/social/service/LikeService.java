/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Like;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.repository.LikeRepository;
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
public class LikeService {
    
    @Autowired
	private LikeRepository likeRepository;

        public List<Like> findByPost(Long id) {
            return likeRepository.findByPostId(id);
        }

	public Like loadById(Long id) {
            return likeRepository.findOne(id);
	}
        
        public void postLike(Like like) {
            likeRepository.save(like);
        }
        
        public void deleteLike(Like like) {
            likeRepository.delete(like);
        }
        
        public Like findByUserAndPost(Like like) {
            return likeRepository.findByUserAndPost(like.getUser(), like.getPost());
        }

}
