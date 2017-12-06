/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Picture;
import br.com.crescer.social.entity.Tag;
import br.com.crescer.social.repository.TagRepository;
import java.util.LinkedList;
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
public class TagService {
    
    @Autowired
	private TagRepository tagRepository;

	public List<Tag> list(Pageable pageable) {
            return (List)tagRepository.findAll(pageable);
	}
        
        public List<Tag> findByPictureId(Long id) {
            return tagRepository.findByPictureId(id);
        }

	public Tag loadById(Long id) {
            return tagRepository.findOne(id);
	}
        
        public void postTag(Tag tag) {
            tagRepository.save(tag);
        }
        
        public void updateTag(Tag tag) {
            tagRepository.save(tag);
        }
        
        public void deleteTag(Tag tag) {
            tagRepository.delete(tag);
        }

}
