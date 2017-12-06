package br.com.crescer.social;

import br.com.crescer.social.controller.UserController;
import br.com.crescer.social.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author carloshenrique
 */
@SpringBootApplication
public class Run {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        System.out.println(encoder.encode("abc123"));
        
        
    }

}
