/*package br.com.skytour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import br.com.skytour.model.MyUserDetails;
import br.com.skytour.model.Passageiro;
import br.com.skytour.repository.PassageiroRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	 @Autowired
	    private PassageiroRepository passageiroRepository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Passageiro passageiro = passageiroRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

	        return new MyUserDetails(passageiro);
	    }
}
*/