/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Friendship;
import br.com.crescer.social.entity.UserEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bel.cogo
 */
public interface FriendshipRepository extends PagingAndSortingRepository<Friendship, Long> {
        
    Page<Friendship> findByUserOneIdAndFsStatus(Long id, boolean status, Pageable pageable);
    
    List<Friendship> findByUserOneIdAndFsStatus(Long id, boolean status);
    
    List<Friendship> findByUserTwoIdAndFsStatus(Long id, boolean status);
    
    Page<Friendship> findByUserTwoIdAndFsStatus(Long id, boolean status, Pageable pageable);
    
    List<UserEntity> findByIdNotIn(List<Long> ids, Pageable pageable);
    
    Friendship findByUserOneIdAndUserTwoId(Long userOneId, Long userTwoId);
    
    List<Friendship> findAll();
    
}
