package fr.philwronski.probook.security;

import fr.philwronski.probook.account.Authority;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SpringSecurityUser implements UserDetails {

    private UUID id;

    private String username;
    private String password;
    private List<Authority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

}
