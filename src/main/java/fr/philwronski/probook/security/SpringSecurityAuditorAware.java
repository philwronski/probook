package fr.philwronski.probook.security;

import fr.philwronski.probook.account.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<UUID> {

    @Override
    public UUID getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        if (authentication.getPrincipal() instanceof SpringSecurityUser) {
            SpringSecurityUser user = (SpringSecurityUser) authentication.getPrincipal();
            return user.getId();
        }

        return null;
    }
}