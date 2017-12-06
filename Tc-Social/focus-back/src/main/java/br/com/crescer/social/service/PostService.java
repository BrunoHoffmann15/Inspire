/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Album;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.repository.FriendshipRepository;
import br.com.crescer.social.repository.PostRepository;
import br.com.crescer.social.repository.UserRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bel.cogo
 */
@Service
public class PostService {
    
    @Autowired
	private PostRepository postRepository;
    
    @Autowired
	private FriendshipRepository friendshipRepository;

        public List<Post> findByUser(UserEntity user) {
            return postRepository.findByUserId(user.getId());
        }
        
        public List<Post> findByUserOrUserOrderById(UserEntity user) {
            List<UserEntity> users = new LinkedList<>();
            
            users.addAll(friendshipRepository.findByUserOneIdAndFsStatus(user.getId(), true)
                    .stream()
                    .map(x -> x.getUserTwo())
                    .collect(Collectors.toList()));
            
            users.addAll(friendshipRepository.findByUserTwoIdAndFsStatus(user.getId(), true)
                    .stream()
                    .map(x -> x.getUserOne())
                    .collect(Collectors.toList()));
            
            
            return postRepository.findByUserOrUserOrderById(user, users);
        }
    
	public Page<Post> list(Pageable pageable) {
            return postRepository.findAll(pageable);
	}

	public Post loadById(Long id) {
            return postRepository.findOne(id);
	}
        
        public void postPost(Post post) {
            postRepository.save(post);
        }
        
        public void updatePost(Post post) {
            postRepository.save(post);
        }
        
        public void deletePost(Post post) {
            postRepository.delete(post);
        }
//        
//        public List<Post> findByAlbum(Long id) {
//            return postRepository.findByAlbumId(id);
//        }

}
