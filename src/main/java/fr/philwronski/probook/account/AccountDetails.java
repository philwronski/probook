package fr.philwronski.probook.account;

import fr.philwronski.probook.audit.AbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "account_details")
public class AccountDetails extends AbstractAuditingEntity {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private int age;

}
