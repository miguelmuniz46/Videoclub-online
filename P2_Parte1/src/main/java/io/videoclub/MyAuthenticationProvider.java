package io.videoclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserRepository userRepository;
	
	public MyAuthenticationProvider(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws BadCredentialsException{
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		User user = userRepository.findByUser(username);
		
		if(user == null) {
			throw new BadCredentialsException("User not found");
		}
		if(!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			throw new BadCredentialsException("Wrong password");
		}
		
		return new UsernamePasswordAuthenticationToken(username, password, user.getRoles());
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
