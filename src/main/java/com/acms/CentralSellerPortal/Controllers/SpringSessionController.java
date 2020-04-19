package com.acms.CentralSellerPortal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SpringSessionController {
    @RequestMapping(value="/destroy" )
    public RedirectView destroyingSession(HttpSession session)
    {
        System.out.println("inside session controller...");
        session.invalidate();
//        RedirectView rv = new RedirectView();
//        String rurl = "/index.html";
//        rv.setUrl(rurl);
//        return  rv;
        return new RedirectView("/");
    }
}
