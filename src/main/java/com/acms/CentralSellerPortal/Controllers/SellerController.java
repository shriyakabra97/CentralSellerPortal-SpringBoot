package com.acms.CentralSellerPortal.Controllers;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;


    @RequestMapping(value="/addseller"   , method=RequestMethod.POST)
    public RedirectView addseller(
                                @RequestParam("s_name") String seller_name,
                               @RequestParam("s_address") String seller_address,
                               @RequestParam("s_shop") String shop_name,
                               @RequestParam("s_mail") String seller_emailId,
                               @RequestParam("s_mobile") String seller_contactNo,
                               @RequestParam("s_password") String password


                               ) {

        List<Seller> seller = new ArrayList<Seller>();
        seller = sellerRepository.findAll();

        for(Seller s: seller) {
            if ((seller_contactNo).equals(s.getSellerContactNo()) || (seller_emailId).equals(s.getSellerEmailId()) || (shop_name).equals(s.getShopName())) {

                RedirectView redirectView = new RedirectView();
                redirectView.setContextRelative(true);
                redirectView.setUrl("/FailedSellerSignup.jsp");
                return redirectView;
            }
        }

        Seller seller1=new Seller();
        seller1.setSellerName(seller_name);
        seller1.setSellerAddress(seller_address);
        seller1.setShopName(shop_name);
        seller1.setSellerEmailId(seller_emailId);
        seller1.setSellerContactNo(seller_contactNo);
        seller1.setSellerPassword(password);
        sellerRepository.save(seller1);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/RedirectToIndexAfterAddingSeller.html");
        return redirectView;
    }

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

//    @RequestMapping(value="/viewSeller/{id}" , method=RequestMethod.GET)
//
//    public ResponseEntity<Seller>    getSellerById(@PathVariable(value = "id") Long seller_id)
//    {
//        Seller seller =sellerRepository.findById(seller_id).orElse(null);
//        return ResponseEntity.ok().body(seller);
//    }


    @RequestMapping(value="/viewSeller/{id}" ,method=RequestMethod.GET)
    public RedirectView getSellerById(@PathVariable(value = "id") long seller_id, HttpSession session)
    {
        System.out.println("Getting your details seller..please wait!!");
        System.out.println(seller_id);
        Seller seller = sellerRepository.findById(seller_id).orElse(null);

        session.setAttribute("sellerContactNo", seller.getSellerContactNo());
        session.setAttribute("sellerAddress", seller.getSellerAddress());
        session.setAttribute("sellerName", seller.getSellerName());
        session.setAttribute("sellerEmailId", seller.getSellerEmailId());
        session.setAttribute("shopName", seller.getShopName());
        session.setAttribute("sellerPassword",seller.getSellerPassword());
        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+Long.toString(seller.getSellerId());
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;
    }



    @RequestMapping(value="/UpdateSeller/{id}" , method=RequestMethod.POST)
    public RedirectView updateUser(
            @PathVariable(value = "id") Long seller_id,
            @RequestParam("s_name") String seller_name,
            @RequestParam("s_address") String seller_address,
            @RequestParam("s_shop") String shop_name,
            @RequestParam("s_mail") String seller_emailId,
            @RequestParam("s_mobile") String seller_contactNo,
            @RequestParam("s_password") String password , HttpSession session)
    {

        List<Seller> seller = new ArrayList<Seller>();
        seller = sellerRepository.findAll();
        for(Seller s: seller) {
            if ((seller_contactNo).equals(s.getSellerContactNo()) || (seller_emailId).equals(s.getSellerEmailId()) || (shop_name).equals(s.getShopName())) {

                RedirectView rv = new RedirectView();
                rv.setContextRelative(true);
                String rurl="/SellerDashboard.jsp?id="+Long.toString(s.getSellerId());
                rv.setUrl(rurl);
                return rv;
            }
        }
        Seller seller1 =sellerRepository.findById(seller_id).orElse(null);
        System.out.println("hi................................");
        seller1.setSellerName(seller_name);
        seller1.setSellerAddress(seller_address);
        seller1.setShopName(shop_name);
        seller1.setSellerEmailId(seller_emailId);
        seller1.setSellerContactNo(seller_contactNo);
        seller1.setSellerPassword(password);
        sellerRepository.save(seller1);
        session.setAttribute("sellerContactNo", seller1.getSellerContactNo());
        session.setAttribute("sellerAddress", seller1.getSellerAddress());
        session.setAttribute("sellerName", seller1.getSellerName());
        session.setAttribute("sellerEmailId", seller1.getSellerEmailId());
        session.setAttribute("shopName", seller1.getShopName());
        session.setAttribute("sellerPassword",seller1.getSellerPassword());
        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+Long.toString(seller1.getSellerId());
        rv.setUrl(rurl);
        return rv;
    }

}
