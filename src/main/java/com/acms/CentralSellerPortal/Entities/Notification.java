package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="notification")

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long notification_id;

    @Column
    @NotNull
    private String notification_message;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id") //nullable = false)
    private Seller seller;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id") //nullable = false)
    private Product product;

    @Column
    @NotNull
    private Date date;




    public Notification(int notification_id, @NotNull String notification_message, int seller_id, int product_id, Date date) {
        this.notification_id = notification_id;
        this.notification_message = notification_message;
        this.seller_id = seller_id;
        this.product_id = product_id;
        this.date=date;

    }

    public long getNotificationId() {
        return notification_id;
    }

    public void setProductId(long product_id) {
        this.notification_id = notification_id;
    }

    public String getNotificationMessage() {
        return notification_message;
    }

    public void setNotificationMessage(String notification_message) {
        this.notification_message = notification_message;
    }

    public int getSellerId() {
        return seller_id;
    }

    public void setSellerId(int seller_id) {
        this.seller_id = seller_id;
    }
    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }


  
    }
  }
