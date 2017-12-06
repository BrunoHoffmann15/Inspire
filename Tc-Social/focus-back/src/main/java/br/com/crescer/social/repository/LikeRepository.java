/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Like;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.UserEntity;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bel.cogo
 */
public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {
    
    List<Like> findByPostId(Long id);
    Like findByUserAndPost(UserEntity user, Post post);
}
