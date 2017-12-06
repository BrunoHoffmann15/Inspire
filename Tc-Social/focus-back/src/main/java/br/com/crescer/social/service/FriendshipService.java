/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Friendship;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.repository.FriendshipRepository;
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
public class FriendshipService {
    
    @Autowired
	private FriendshipRepository friendshipRepository;

        public Page<UserEntity> findByUserOne(Pageable pageable, UserEntity user) {
           Page<UserEntity> friends;
           
           friends = friendshipRepository.findByUserOneIdAndFsStatus(user.getId(), true, pageable)
                    .map(friendship -> friendship.getUserTwo());

           if(friends.getContent().isEmpty()){
               friends = friendshipRepository.findByUserTwoIdAndFsStatus(user.getId(), true, pageable)
                    .map(friendship -> friendship.getUserOne());
           }          
           
           return friends;
        }
        
        public Page<UserEntity> listSolicitations(Pageable pageable, UserEntity user) {
            return friendshipRepository.findByUserTwoIdAndFsStatus(user.getId(), false, pageable)
                    .map(friendship -> friendship.getUserOne());
        }
        
        public Page<UserEntity> listNotFriends(Pageable pageable, UserEntity user) {
            List<Long> ids = friendshipRepository.findByUserOneIdAndFsStatus(user.getId(), false).stream().map(friendship -> friendship.getUserTwo().getId()).collect(Collectors.toList());
            
            return (Page)friendshipRepository.findByIdNotIn(ids, pageable);
        }
        
	public Page<Friendship> list(Pageable pageable) {
            return friendshipRepository.findAll(pageable);
	}

	public Friendship loadById(Long id) {
            return friendshipRepository.findOne(id);
	}
        
        public void postFriendship(Friendship friendship) {
            friendshipRepository.save(friendship);
        }
        
        public void updateFriendship(Friendship friendship) {
            friendshipRepository.save(friendship);
        }
        
        public void deleteFriendship(Friendship friendship) {
            friendshipRepository.delete(friendship);
        }
        
        public Friendship findOneByUsers(Long idOne, Long idTwo) {
            return friendshipRepository.findByUserOneIdAndUserTwoId(idOne, idTwo);
        }

}
