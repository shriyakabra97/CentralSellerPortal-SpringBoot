package com.acms.CentralSellerPortal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name="seller")
public class Seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerId;

    @Column
    @Size(max=50)
    @NotNull
    private String sellerName;

    @Column
    @Size(max=100)
    @NotNull
    private String sellerAddress;

    @Column
    @Size(max=50)
    @NotNull
    private String shopName;

    @Column(unique= true)
    @Size(max=10)
    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})")
    private String sellerContactNo;

    @Column(unique= true)
    @Size(max=30)
    @NotNull
    @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)")
    private String sellerEmailId;

    @Column
    @NotNull
    @Pattern(regexp="(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$)")
    private String sellerPassword;



    public Seller() {}


    public Seller(@Size(max = 50) @NotNull String sellerName, @Size(max = 100) @NotNull String sellerAddress, @Size(max = 50) @NotNull String shopName, @Size(max = 10) @NotNull @Pattern(regexp = "(^$|[0-9]{10})") String sellerContactNo, @Size(max = 30) @NotNull @Pattern(regexp = "(^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$)") String sellerEmailId, @NotNull @Pattern(regexp = "(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$)") String sellerPassword) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.shopName = shopName;
        this.sellerContactNo = sellerContactNo;
        this.sellerEmailId = sellerEmailId;
        this.sellerPassword = sellerPassword;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long seller_id) {
        this.sellerId = seller_id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String seller_name) {
        this.sellerName = seller_name;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String seller_address) {
        this.sellerAddress = seller_address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shop_name) {
        this.shopName = shop_name;
    }

    public String getSellerContactNo() {
        return sellerContactNo;
    }

    public void setSellerContactNo(String seller_contactNo) {
        this.sellerContactNo = seller_contactNo;
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public void setSellerEmailId(String seller_emailId) {
        this.sellerEmailId = seller_emailId;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String seller_password) {
        this.sellerPassword = seller_password;
    }



}
