package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;



    public Notification() {
    }

    public Notification(@NotNull String notification_message, Seller seller, Product product, java.sql.@NotNull Timestamp timestamp) {
        this.notification_message = notification_message;
        this.seller = seller;
        this.product = product;
        this.timestamp = timestamp;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
