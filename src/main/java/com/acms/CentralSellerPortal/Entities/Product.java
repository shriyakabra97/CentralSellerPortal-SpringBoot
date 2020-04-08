package com.acms.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long product_id;

        @Column
        @NotNull
        private String product_name;

        @Column
        @NotNull
        private String product_description;

        @Column
        @NotNull
        private int price;

        @Column
        @NotNull
        private int discount;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "seller_id", nullable = false)
        private Seller seller;

    public Product() {
    }

    public Product(int product_id, @NotNull String product_name, @NotNull int price, @NotNull String product_description, @NotNull int discount, Seller seller) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.product_description = product_description;
        this.discount = discount;
        this.seller = seller;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
