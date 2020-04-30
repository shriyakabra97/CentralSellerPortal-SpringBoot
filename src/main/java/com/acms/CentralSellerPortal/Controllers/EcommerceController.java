package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
import com.acms.CentralSellerPortal.Services.EcommerceService;
import com.acms.CentralSellerPortal.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class EcommerceController {

    @Autowired
    EcommerceService ecommerceService;

    @Autowired
    SellerService sellerService;

    @Autowired
    EcommerceRepository ecommerceRepository;

    @PostMapping("/postEcommerce")
    public RedirectView postEcommerce(@RequestParam("cName") String ecommerce_name,
                                     @RequestParam("cEmailId") String ecommerce_emailId,
                                     @RequestParam("cPassword") String ecommerce_password)
    {

        Ecommerce ecommerce=new Ecommerce(ecommerce_name,ecommerce_emailId,ecommerce_password);
        ecommerceRepository.save(ecommerce);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/index.html");
        return redirectView;
    }

   /* @GetMapping("/getAllEcommerce")
    public ResponseEntity<List<Ecommerce>> getAllEcommerce() {
        List<Ecommerce> ecommerceList =ecommerceService.findAll();
        return ResponseEntity.ok().body(ecommerceList);
    } */

    @RequestMapping(value="/getEcommerceById/{e_id}" ,method=RequestMethod.GET)
    public RedirectView getEcommerceById(@PathVariable(value = "e_id") long ecomm_id, HttpSession session)
    {
        Ecommerce ecommerce = ecommerceRepository.findById(ecomm_id).orElse(null);

        session.setAttribute("ecommEmailId", ecommerce.getEcommEmailId());
        session.setAttribute("ecommName", ecommerce.getEcommName());

        RedirectView rv = new RedirectView();
        String rurl="/ViewEcommProfile.jsp?e_id="+ecommerce.getEcommId();
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;
    }

    @RequestMapping(value="/putEcommerce/{e_id}" , method=RequestMethod.POST)
    public RedirectView putEcommerce(
            @PathVariable(value = "e_id") Long ecommId,
            @RequestParam("c_name") String ecommName,
            @RequestParam("c_mail") String ecommEmailId,
            @RequestParam("c_password") String password,
            HttpSession session)
    {
        Ecommerce ecommerce=ecommerceRepository.findById(ecommId).orElse(null);
        ecommerce.setEcommName(ecommName);
        ecommerce.setEcommEmailId(ecommEmailId);
        ecommerce.setEcommPassword(password);
        session.setAttribute("ecommName", ecommerce.getEcommName());
        session.setAttribute("ecommEmailId", ecommerce.getEcommEmailId());
        session.setAttribute("ecommPassword", ecommerce.getEcommPassword());

        ecommerceService.save(ecommerce);
        RedirectView rv = new RedirectView();
        String rurl="/EcommDashboard.jsp?e_id="+ecommerce.getEcommId();
        rv.setUrl(rurl);
        return rv;
    }


    @GetMapping(value = "/getAllSellers/{e_id}")
    public RedirectView getAllSellers(
            @PathVariable("e_id") Long ecommId,
            HttpSession session)
    {
        List<Seller> allSellerList =sellerService.findAll();
        session.setAttribute("allSellerList",allSellerList );
        RedirectView rv = new RedirectView();
        System.out.println(session.getAttributeNames());
        String rurl="/DisplayAllProducts.jsp?e_id="+ecommId;
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;

    }



}