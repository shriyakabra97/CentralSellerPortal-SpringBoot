package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name="notification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long notification_id;

    @Column
    @NotNull
    private String notification_message;

    @Column
    private long sellerId;

    @Column
    private long productId;

    @Column
    private Date ndate=new Date(2323223232L);

    @Column
    private boolean isUpdate;


    public Notification() {
    }

    public Notification(@NotNull String notification_message, long seller_id, long productId, Date ndate, boolean isUpdate) {
        this.notification_message = notification_message;
        this.sellerId = seller_id;
        this.productId = productId;
        this.ndate = ndate;
        this.isUpdate = isUpdate;
    }

    public Notification(@NotNull String notification_message) {
        this.notification_message = notification_message;
    }

    public Notification(String message, Date date, long s_id, long p_id, boolean update) {
        this.notification_message = message;
        this.ndate = date;
        this.sellerId = s_id;
        this.productId = p_id;
        this.isUpdate = update;
    }

    public long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(long notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_message() {
        return notification_message;
    }

    public void setNotification_message(String notification_message) {
        this.notification_message = notification_message;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public boolean isUpdate() { return isUpdate; }

    public void setUpdate(boolean update) { isUpdate = update; }
}