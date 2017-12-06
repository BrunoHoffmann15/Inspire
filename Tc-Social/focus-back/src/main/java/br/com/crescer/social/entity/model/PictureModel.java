/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Bel
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureModel {
    
    private Long idAlbum;
    private Long idPost;
    private String url;
    
}
