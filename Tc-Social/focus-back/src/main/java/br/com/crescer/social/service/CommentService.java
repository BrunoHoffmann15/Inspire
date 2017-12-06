/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entity.Comment;
import br.com.crescer.social.entity.Post;
import br.com.crescer.social.repository.CommentRepository;
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
public class CommentService {
    
    @Autowired
	private CommentRepository commentRepository;

        public List<Comment> findByPost(Long id) {            
            return commentRepository.findByPostId(id);            
        }
    
	public Page<Comment> list(Pageable pageable) {
            return commentRepository.findAll(pageable);
	}

	public Comment loadById(Long id) {
            return commentRepository.findOne(id);
	}
        
        public void postComment(Comment comment) {
            commentRepository.save(comment);
        }
        
        public void updateComment(Comment comment) {
            commentRepository.save(comment);
        }
        
        public void deleteComment(Comment comment) {
            commentRepository.delete(comment);
        }

}
