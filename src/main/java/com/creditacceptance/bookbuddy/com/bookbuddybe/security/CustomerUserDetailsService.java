package com.creditacceptance.bookbuddy.com.bookbuddybe.security;

import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CustomerUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //get user from the DB
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found with email: " + email));
        //convert set of the roles into set of granted authorities
        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors
                .toSet());
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), authorities);
    }
}
