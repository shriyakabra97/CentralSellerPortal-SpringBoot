package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ecommerce")

public class Ecommerce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ecommId;

    @Column
    @Size(max=50)
    @NotNull
    private String ecommName;

    @Column(unique= true)
    @Size(max=30)
    @NotNull
    @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)")
    private String ecommEmailId;

    @Column
    @NotNull
    @Pattern(regexp="(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$)")
    private String ecommPassword;

    @NotNull
    @Column
    private Date date=new Date(2323223232L);

    @Column
    private boolean first_login = true;

    public Ecommerce(){}

    public Ecommerce(@Size(max = 50) @NotNull String ecommName, @Size(max = 30) @NotNull @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)") String ecommEmailId, @NotNull @Pattern(regexp = "(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$)") String ecommPassword, @NotNull Date date, boolean first_login) {
        this.ecommName = ecommName;
        this.ecommEmailId = ecommEmailId;
        this.ecommPassword = ecommPassword;
        this.date = date;
        this.first_login = first_login;
    }

    public Ecommerce(@Size(max = 50) @NotNull String ecommName, @Size(max = 30) @NotNull @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)") String ecommEmailId, @NotNull @Pattern(regexp = "(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$)") String ecommPassword) {
        this.ecommName = ecommName;
        this.ecommEmailId = ecommEmailId;
        this.ecommPassword = ecommPassword;
    }

    public boolean isFirst_login() {
        return first_login;
    }

    public void setFirst_login(boolean first_login) {
        this.first_login = first_login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
