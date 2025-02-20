package com.coba_springboot.halo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 3247696593017334807L;
	
	private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at", nullable = true, insertable = true, updatable = false)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String createdBy;

    @Column(name = "created_by", nullable = true, insertable = true, updatable = false, length = 25, precision = 0)
    @CreatedBy
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true, insertable = true, updatable = true)
    @LastModifiedDate
    @CreatedDate
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private String updatedBy;

    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @LastModifiedBy
    @CreatedBy
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date deletedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at", nullable = true, insertable = true, updatable = true)
    @LastModifiedDate
    @CreatedDate
    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
