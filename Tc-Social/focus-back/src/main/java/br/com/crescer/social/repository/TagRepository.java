/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Tag;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bel.cogo
 */
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    
    List<Tag> findByPictureId(Long id);
}
