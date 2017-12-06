package br.com.crescer.social.security;

import br.com.crescer.social.service.UserService;
import br.com.crescer.social.entity.UserEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public static class CustomUserDetails extends User {

		@Getter
		@Setter
		private String nome;

		public CustomUserDetails(UserEntity user, Collection<? extends GrantedAuthority> authorities
		) {
			super(user.getEmail(), user.getPasswd(), authorities);
			this.nome = user.getName();
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final UserEntity user = userService.findByEmail(username);
		if (user == null) {
			return null;
		}
		final List<GrantedAuthority> grants = new ArrayList<>();
		grants.add(() -> "ROLE_ADMIN");
		return new CustomUserDetails(user, grants);
	}
}
