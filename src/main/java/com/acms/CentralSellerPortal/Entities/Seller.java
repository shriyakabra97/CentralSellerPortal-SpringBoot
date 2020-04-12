package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name="seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerId;

    @Column
    @Size(max=100)
    @NotNull
    private String sellerName;

    @Column
    @Size(max=300)
    @NotNull
    private String sellerAddress;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String shopName;

    @Column(unique= true)
    @Size(max=10)
    @NotNull
    private String sellerContactNo;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String sellerEmailId;

    @Column
    @NotNull
    private String sellerPassword;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> product;

    public Seller() {}


    public Seller(@NotNull String seller_name, @NotNull String seller_address, @NotNull String shop_name, @NotNull String seller_contactNo, @NotNull String seller_emailId , @NotNull String seller_password ) {
        this.sellerName = seller_name;
        this.sellerAddress = seller_address;
        this.shopName = shop_name;
        this.sellerContactNo = seller_contactNo;
        this.sellerEmailId = seller_emailId;
        this.sellerPassword = seller_password;
    }

   public Seller(@NotNull String seller_name, @NotNull String seller_address, @NotNull String shop_name, @NotNull String seller_contactNo, @Size(max = 10) @NotNull String seller_emailId, Product product) {
        this.sellerName = seller_name;
        this.sellerAddress = seller_address;
        this.shopName = shop_name;
        this.sellerContactNo = seller_contactNo;
        this.sellerEmailId = seller_emailId;
        this.product = (List<Product>) product;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSellerContactNo() {
        return sellerContactNo;
    }

    public void setSellerContactNo(String sellerContactNo) {
        this.sellerContactNo = sellerContactNo;
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public void setSellerEmailId(String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }


    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }


}
