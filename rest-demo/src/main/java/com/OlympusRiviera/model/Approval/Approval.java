package com.OlympusRiviera.model.Approval;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Approval")
@Data
public class Approval {
    @Id
    private String approval_id;
    private String approval_type;
    private String entity_id;
    private String entity_type;
    private String provider_id;
    private String employee_id;
    private String status;


    @Column(updatable = false) // Prevent overwriting during updates
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Approval() {
    }

    public Approval(String approval_id, String approval_type, String entity_id, String entity_type, String provider_id, String employee_id, String status, Date createdAt, Date updatedAt) {
        this.approval_id = generateId();
        this.approval_type = approval_type;
        this.entity_id = entity_id;
        this.entity_type = entity_type;
        this.provider_id = provider_id;
        this.employee_id = employee_id;
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }


    private String generateId() {
        return "approv_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8); // Prefix with 'destcat'
    }


    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }
        if (this.approval_id == null) {
            this.approval_id = generateId();
        }
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date(); // Update the updatedAt field
    }
}