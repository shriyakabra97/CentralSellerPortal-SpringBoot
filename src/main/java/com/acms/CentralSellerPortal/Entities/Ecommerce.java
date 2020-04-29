package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Entity
@Table(name="ecommerce")

public class Ecommerce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ecommId;

    @Column
    @Size(max=100)
    @NotNull
    private String ecommName;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String ecommEmailId;

    @Column
    @NotNull
    private String ecommPassword;

    @Column
    @NotNull
    private Timestamp sqlTimestamp;

    public Ecommerce() {
    }

    public Ecommerce(long ecommId, @Size(max = 100) @NotNull String ecommName, @Size(max = 100) @NotNull String ecommEmailId, @NotNull String ecommPassword) {
        this.ecommId = ecommId;
        this.ecommName = ecommName;
        this.ecommEmailId = ecommEmailId;
        this.ecommPassword = ecommPassword;
    }

    public Ecommerce(@Size(max = 100) @NotNull String ecommName, @Size(max = 100) @NotNull String ecommEmailId, @NotNull String ecommPassword, @NotNull Timestamp sqlTimestamp) {
        this.ecommName = ecommName;
        this.ecommEmailId = ecommEmailId;
        this.ecommPassword = ecommPassword;
        this.sqlTimestamp = sqlTimestamp;
    }

    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    public long getEcommId() {
        return ecommId;
    }


    public void setEcommId(long ecommId) {
        this.ecommId = ecommId;
    }

    public String getEcommName() {
        return ecommName;
    }

    public void setEcommName(String ecommName) {
        this.ecommName = ecommName;
    }

    public String getEcommEmailId() {
        return ecommEmailId;
    }

    public void setEcommEmailId(String ecommEmailId) {
        this.ecommEmailId = ecommEmailId;
    }

    public String getEcommPassword() {
        return ecommPassword;
    }

    public void setEcommPassword(String ecommPassword) {
        this.ecommPassword = ecommPassword;
    }
}
