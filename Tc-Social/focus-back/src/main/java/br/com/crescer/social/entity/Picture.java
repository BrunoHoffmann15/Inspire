/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author bel.cogo
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PICTURE")
public class Picture implements Serializable{
    
    private static final String SQ_NAME = "SQ_PICTURE";

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
	@SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
	@Column(name = "ID_PICTURE")
	private Long id;
        
        @ManyToOne
        @JoinColumn(name = "ID_POST", nullable = false)
        private Post post;
        
        @Basic(optional = false)
        @Column(name = "URL_IMAGE", nullable = false, length = 512)
        private String urlImage;
        
        @ManyToOne
        @JoinColumn(name = "ID_ALBUM", nullable = false)
        private Album album;

}
