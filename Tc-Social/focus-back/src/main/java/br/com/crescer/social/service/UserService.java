/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Friendship;
import br.com.crescer.social.entity.UserEntity;
import br.com.crescer.social.repository.FriendshipRepository;
import br.com.crescer.social.repository.UserRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bel.cogo
 */
@Service
public class UserService {
    
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
	private FriendshipRepository friendshipRepository;

	public UserEntity findByEmail(String username) {
		return userRepository.findByEmailIgnoreCase(username);
	}

	public Page<UserEntity> list(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public UserEntity loadById(Long id) {
		return userRepository.findOne(id);
	}
        
        public void postUser(UserEntity user) {
            user.setPasswd(encryptPasswd(user.getPasswd()));
            userRepository.save(user);
        }
        
        public void updateUser(UserEntity user) {
            userRepository.save(user);
        }
        
        public void deleteUser(UserEntity user) {
            userRepository.delete(user);
        }
        
        public String encryptPasswd(String passwd) {
            BCryptPasswordEncoder userPassword = new BCryptPasswordEncoder();
            
            return userPassword.encode(passwd);
        }
        
        public Page<UserEntity> findNotFriends(Pageable pageable, UserEntity user) {
            List<Long> ids = new LinkedList<>();
            
            ids.addAll(friendshipRepository.findByUserOneIdAndFsStatus(user.getId(), true).stream().map(x -> x.getUserTwo().getId()).collect(Collectors.toList()));
            
            ids.addAll(friendshipRepository.findByUserTwoIdAndFsStatus(user.getId(), true).stream().map(x -> x.getUserOne().getId()).collect(Collectors.toList()));
            
            if(ids.isEmpty()) {
                return userRepository.findAll(pageable);
            }
            
            return userRepository.findByIdNotIn(ids, pageable);
        }
}
