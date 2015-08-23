package com.blankpix.smallz.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;

@MappedSuperclass
public abstract class AuditDtls {

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Basic(optional = false)
    @Column(name = "CREATED_TS", updatable = false)
    private Timestamp createdTs;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Basic(optional = false)
    @Column(name = "MODIFIED_TS")
    private Timestamp modifiedTs;
    
    @Basic(optional = false)
    @Column(name = "START_DT")
    private Timestamp startDt;
    
    @Column(name = "END_DT")
    private Timestamp endDt;

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the createdTs
     */
    public Timestamp getCreatedTs() {
        return createdTs;
    }

    /**
     * @param createdTs the createdTs to set
     */
    public void setCreatedTs(Timestamp createdTs) {
        if (createdTs == null) {
            createdTs = new Timestamp(DateTime.now().getMillis());
        }
        this.createdTs = createdTs;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedTs
     */
    public Timestamp getModifiedTs() {
        return modifiedTs;
    }

    /**
     * @param modifiedTs the modifiedTs to set
     */
    public void setModifiedTs(Timestamp modifiedTs) {
        if (modifiedTs == null) {
            modifiedTs = new Timestamp(DateTime.now().getMillis());
        }
        this.modifiedTs = modifiedTs;
    }

    public Timestamp getStartDt() {
		return startDt;
	}

	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}

	public Timestamp getEndDt() {
		return endDt;
	}

	public void setEndDt(Timestamp endDt) {
		this.endDt = endDt;
	}

	@PrePersist
    void onCreate() {
        this.setCreatedBy("test");
        this.setModifiedBy("test");
        this.setCreatedTs(new Timestamp(DateTime.now().getMillis()));
        this.setModifiedTs(new Timestamp(DateTime.now().getMillis()));
    }

    @PreUpdate
    void onPersist() {
        this.setModifiedBy("test");
        this.setModifiedTs(new Timestamp(DateTime.now().getMillis()));
    }
}
