package fr.philwronski.probook.account;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class Authority implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private final Role role;

    @Override
    public String getAuthority() {
        return role.name();
    }

    public Authority(Role role) {
        this.role = role;
    }

    public Authority(String role) {
        this.role = Role.valueOf(role);
    }
}
