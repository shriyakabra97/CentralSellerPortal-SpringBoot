package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product, Long> {
}