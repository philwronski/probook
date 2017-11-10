package fr.philwronski.probook.audit;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(updatable = false)
    private UUID createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    private UUID lastModifiedBy;
}
