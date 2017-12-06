/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

/**
 *
 * @author bel.cogo
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USER")
public class UserEntity implements Serializable{
    
    private static final String SQ_NAME = "SQ_USER";

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
	@SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
	@Column(name = "ID_USER")
	private Long id;

	@Basic(optional = false)
	@Column(name = "NM_USER", nullable = false, length = 255)
	private String name;
        
        @Basic(optional = true)
        @Column(name = "NICKNAME", nullable = true, length = 50)
        private String nickname;

	@Basic(optional = false)
	@Column(name = "EMAIL", unique = true, nullable = false, length = 255)
	private String email;

	@Basic(optional = false)
	@Column(name = "PASS", nullable = false, length = 4000)
	private String passwd;
        
        @Basic(optional = false)
        @Column(name = "BIRTH_DATE")        
        @JsonFormat(pattern = "dd/MM/yyyy")
        @Convert(converter = LocalDateConverter.class)
        private LocalDate birthDate;
        
        @Basic(optional = true)
        @Column(name = "PROFILE_PICTURE", nullable = true, length = 512)
        private String profilePicture;
    
}
