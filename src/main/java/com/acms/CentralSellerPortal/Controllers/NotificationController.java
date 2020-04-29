package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Notification;
import com.acms.CentralSellerPortal.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;

 /*   @RequestMapping(value = "/getAllNotification/{e_id}", method = RequestMethod.GET)
    public RedirectView getProductBySellerId(@PathVariable(value = "e_id") long e_id, HttpSession session)
    {
        List<Notification> notificationList = notificationService.findByE_Id(e_id);

        session.setAttribute("notificationList",notificationList);
        RedirectView rv = new RedirectView();
        String rurl="/Ecommdashboard.jsp?id="+e_id;
        rv.setUrl(rurl);
        return rv;

    } */
}
