package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
