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
    private long seller_id;

    @Column
    @Size(max=100)
    @NotNull
    private String seller_name;

    @Column
    @Size(max=300)
    @NotNull
    private String seller_address;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String shop_name;

    @Column(unique= true)
    @Size(max=10)
    @NotNull
    private String seller_contactNo;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String seller_emailId;

    @Column
    @NotNull
    private String seller_password;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> product;

    public Seller() {}


    public Seller(@NotNull String seller_name, @NotNull String seller_address, @NotNull String shop_name, @NotNull String seller_contactNo, @NotNull String seller_emailId , @NotNull String seller_password ) {
        this.seller_name = seller_name;
        this.seller_address = seller_address;
        this.shop_name = shop_name;
        this.seller_contactNo = seller_contactNo;
        this.seller_emailId = seller_emailId;
        this.seller_password = seller_password;
    }

   public Seller(@NotNull String seller_name, @NotNull String seller_address, @NotNull String shop_name, @NotNull String seller_contactNo, @Size(max = 10) @NotNull String seller_emailId, Product product) {
        this.seller_name = seller_name;
        this.seller_address = seller_address;
        this.shop_name = shop_name;
        this.seller_contactNo = seller_contactNo;
        this.seller_emailId = seller_emailId;
        this.product = (List<Product>) product;
    }

    public long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(String seller_address) {
        this.seller_address = seller_address;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getSeller_contactNo() {
        return seller_contactNo;
    }

    public void setSeller_contactNo(String seller_contactNo) {
        this.seller_contactNo = seller_contactNo;
    }

    public String getSeller_emailId() {
        return seller_emailId;
    }

    public void setSeller_emailId(String seller_emailId) {
        this.seller_emailId = seller_emailId;
    }

    public String getSeller_password() {
        return seller_password;
    }

    public void setSeller_password(String seller_password) {
        this.seller_password = seller_password;
    }


    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "seller_id=" + seller_id +
                ", seller_name='" + seller_name + '\'' +
                ", seller_address='" + seller_address + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", seller_contactNo='" + seller_contactNo + '\'' +
                ", seller_emailId='" + seller_emailId + '\'' +
                ", seller_password='" + seller_password + '\'' +
                //", product=" + product +
                '}';
    }
}
