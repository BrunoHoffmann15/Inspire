/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.UserEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bel.cogo
 */
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    
    UserEntity findByEmailIgnoreCase(String email);
    Page<UserEntity> findByIdNotIn(List<Long> ids, Pageable pageable);
//    List<UserEntity> findAll();
    
}
