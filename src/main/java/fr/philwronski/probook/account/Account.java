package fr.philwronski.probook.account;

import fr.philwronski.probook.audit.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account extends AbstractAuditingEntity implements UserDetails {

    @Id
    private UUID id;

    private String username;
    private String password;

    @Column(columnDefinition = "TEXT[]")
    @Type(type = "fr.philwronski.probook.configuration.database.StringListDataType")
    private List<Authority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private AccountDetails details;
}
