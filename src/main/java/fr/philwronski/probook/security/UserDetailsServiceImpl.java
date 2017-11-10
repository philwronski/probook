package fr.philwronski.probook.security;

import fr.philwronski.probook.account.Account;
import fr.philwronski.probook.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by p.wronski on 04/10/2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository
                .findByUsername(username)
                .orElseThrow(() ->  new UsernameNotFoundException(String.format("No user found with username %s", username)));

        return SpringSecurityUser.builder()
                .id(account.getId())
                .username(account.getUsername())
                .password(account.getPassword())
                .enabled(account.isEnabled())
                .accountNonExpired(account.isAccountNonExpired())
                .credentialsNonExpired(account.isCredentialsNonExpired())
                .accountNonLocked(account.isAccountNonLocked())
                .authorities(account.getAuthorities())
                .build();
    }
}
