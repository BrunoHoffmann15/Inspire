/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repository;

import br.com.crescer.social.entity.Album;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bel.cogo
 */
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {
    
    public List<Album> findByUserId(Long userId);
    
    public List<Album> findAll();
    
//    public Album findByAlbumName(String name);
    
}
 