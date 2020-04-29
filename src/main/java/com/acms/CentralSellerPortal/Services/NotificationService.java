package com.acms.CentralSellerPortal.Services;

import com.acms.CentralSellerPortal.Entities.Notification;
import com.acms.CentralSellerPortal.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void save(Notification notification)
    {
        notificationRepository.save(notification);
    }

   /* public List<Notification> findByE_Id(long e_id)
    {

    } */
}
