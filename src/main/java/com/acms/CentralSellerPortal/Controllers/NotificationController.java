package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Notification;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
//import com.acms.CentralSellerPortal.Services.EcommerceService;
import com.acms.CentralSellerPortal.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EcommerceRepository ecommerceRepository;

    //@GetMapping("/getAllNotification/{e_id}")
    @RequestMapping(value="/getAllNotification/{e_id}" , method=RequestMethod.GET)
    public RedirectView getNotifications(@PathVariable(value = "e_id") long e_id,
                                     HttpSession session)
    {
        Ecommerce ecommerce=ecommerceRepository.findById(e_id).orElse(null);
        boolean log=ecommerce.isFirst_login();
        List<Notification> notificationList;
        if(log==false) {
            notificationList = notificationService.findByE_Id(e_id);


            session.setAttribute("notificationList", notificationList);
        }
        Date dt=new Date();
        ecommerce.setDate(dt);

        RedirectView rv = new RedirectView();
        String rurl="/Notifications.jsp?e_id="+e_id;
        rv.setUrl(rurl);
        return rv;

    }
}