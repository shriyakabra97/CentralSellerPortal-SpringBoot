
package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {





        @Autowired
        SellerRepository sellerRepository;
        @Autowired
        EcommerceRepository ecommerceRepository;




    @RequestMapping(value="/verifyseller" , method=RequestMethod.GET)
      public RedirectView create(@RequestParam("s_mobile") String s_mobile,
                                 @RequestParam("s_password") String s_password , RedirectAttributes redirectAttrs, HttpSession session){
            List<Seller> seller = new ArrayList<Seller>();
            seller = sellerRepository.findAll();

        for(Seller s: seller){
            if((s_password).equals(s.getSellerPassword()) && (s_mobile).equals(s.getSellerContactNo())){
                Long seller_id=s.getSellerId();
                Seller seller1 = sellerRepository.findById(seller_id).orElse(null);
                session.setAttribute("sellerContactNo", seller1.getSellerContactNo());
                session.setAttribute("sellerAddress", seller1.getSellerAddress());
                session.setAttribute("sellerName", seller1.getSellerName());
                session.setAttribute("sellerEmailId", seller1.getSellerEmailId());
                session.setAttribute("shopName", seller1.getShopName());
                session.setAttribute("sellerPassword",seller1.getSellerPassword());
                RedirectView rv = new RedirectView();
                String rurl="/SellerDashboard.jsp?id="+Long.toString(seller1.getSellerId());
                System.out.println(rurl);
                rv.setUrl(rurl);
                return rv;


      }

    }
	 RedirectView rvf = new RedirectView();
	String furl="/FailedLogin.jsp";
	rvf.setUrl(furl);
    return rvf;
  }

 @RequestMapping(value="/verifyecommerce" , method=RequestMethod.GET)
      public RedirectView createecomm(@RequestParam("c_email") String c_email,
                                 @RequestParam("c_password") String c_password , RedirectAttributes redirectAttrs){
            List<Ecommerce> ecomm = new ArrayList<Ecommerce>();
            ecomm = ecommerceRepository.findAll();

        for(Ecommerce c: ecomm){
            if((c_password).equals(c.getEcommPassword()) && (c_email).equals(c.getEcommEmailId())){

                c.setFirst_login(false);
                RedirectView rv = new RedirectView();
                String rurl="/Ecommdashboard.jsp?id="+Long.toString(c.getEcommId());
                rv.setUrl(rurl);
                return rv;

      }

    }
     RedirectView rvf = new RedirectView();
	String furl="/FailedLogin.jsp";
	rvf.setUrl(furl);
    return rvf;
  }


}


