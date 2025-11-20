package br.edu.ifsp.provaPRW3.api_2025_bes.user;

import br.edu.ifsp.provaPRW3.api_2025_bes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class authService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return repository.findByLogin(username);
    }
}
