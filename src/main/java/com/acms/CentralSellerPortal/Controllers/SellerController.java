/*author ANMOL TUTEJA
creating a Seller Controller
on top of every method we have api
accepting data in json or xml format both
and storing data in session object
*/


package com.acms.CentralSellerPortal.Controllers;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import com.acms.CentralSellerPortal.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/") //setting default mapping to /
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    SellerRepository sellerRepository;


    //post method
    //redirected view to dashboard in success
    //redirect view to failed login page in case of failure
    //this api add seller info to db
    @RequestMapping(value="/addseller"   , method=RequestMethod.POST)
    public RedirectView addseller(
                                @RequestParam("s_name") String seller_name,
                               @RequestParam("s_address") String seller_address,
                               @RequestParam("s_shop") String shop_name,
                               @RequestParam("s_mail") String seller_emailId,
                               @RequestParam("s_mobile") String seller_contactNo,
                               @RequestParam("s_password") String password,
                                HttpSession session) {

        List<Seller> seller;
        seller = sellerRepository.findAll();

        //checking for if entry already exist for unique attribute
        for(Seller s: seller) {
            if ((seller_contactNo).equals(s.getSellerContactNo()) && (seller_emailId).equals(s.getSellerEmailId()) ) {

                session.setAttribute("sellerContactNo", s.getSellerContactNo());
                session.setAttribute("sellerEmailId", s.getSellerEmailId());
                RedirectView redirectView = new RedirectView();
                redirectView.setContextRelative(true);
                redirectView.setUrl("/FailedSellerSignup.jsp");
                return redirectView;
            }
            else
            if ((seller_contactNo).equals(s.getSellerContactNo()) ) {

                session.setAttribute("sellerContactNo", s.getSellerContactNo());
                RedirectView redirectView = new RedirectView();
                redirectView.setContextRelative(true);
                redirectView.setUrl("/FailedSellerSignup.jsp");
                return redirectView;
            }
            else
            if ((seller_emailId).equals(s.getSellerEmailId())) {

                session.setAttribute("sellerEmailId", s.getSellerEmailId());
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
        sellerService.save(seller1);

        //redirecting
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/RedirectToIndexAfterAddingSeller.html");
        return redirectView;
    }


    //Get method
    //this api to display seller info corresponding to id
    //view redirected to dashboard
    @RequestMapping(value="/viewSeller/{id}" ,method=RequestMethod.GET)
    public RedirectView getSellerById(@PathVariable(value = "id") long seller_id, HttpSession session)
    {
        Seller seller = sellerRepository.findById(seller_id).orElse(null);

        session.setAttribute("sellerContactNo", seller.getSellerContactNo());
        session.setAttribute("sellerAddress", seller.getSellerAddress());
        session.setAttribute("sellerName", seller.getSellerName());
        session.setAttribute("sellerEmailId", seller.getSellerEmailId());
        session.setAttribute("shopName", seller.getShopName());
        session.setAttribute("sellerPassword",seller.getSellerPassword());

        //redirecting
        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+Long.toString(seller.getSellerId());
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;
    }

    //post method
    //this api will update seller info in db
    //redirect view to dashboard again
    //redirect to failed page in case of failure
    @RequestMapping(value="/UpdateSeller/{id}" , method=RequestMethod.POST)
    public RedirectView updateUser(
            @PathVariable(value = "id") Long seller_id,
            @RequestParam("s_name") String seller_name,
            @RequestParam("s_address") String seller_address,
            @RequestParam("s_shop") String shop_name,
            @RequestParam("s_mail") String seller_emailId,
            @RequestParam("s_mobile") String seller_contactNo,
            @RequestParam("s_password") String password , HttpSession session) {


             List<Seller> seller = new ArrayList<Seller>();
             seller = sellerRepository.findAll();

             //checking for if entry already exist for unique attribute
             for(Seller s: seller) {
                 if ((seller_contactNo).equals(s.getSellerContactNo()) && (seller_emailId).equals(s.getSellerEmailId()) ) {

                     session.setAttribute("sellerContactNo", s.getSellerContactNo());
                     session.setAttribute("sellerEmailId", s.getSellerEmailId());
                     RedirectView redirectView = new RedirectView();
                     redirectView.setContextRelative(true);
                     redirectView.setUrl("/FailedSellerSignup.jsp");
                     return redirectView;
                 }
                 else
                 if ((seller_contactNo).equals(s.getSellerContactNo()) ) {

                     session.setAttribute("sellerContactNo", s.getSellerContactNo());
                     RedirectView redirectView = new RedirectView();
                     redirectView.setContextRelative(true);
                     redirectView.setUrl("/FailedSellerSignup.jsp");
                     return redirectView;
                 }
                 else
                 if ((seller_emailId).equals(s.getSellerEmailId())) {

                     session.setAttribute("sellerEmailId", s.getSellerEmailId());
                     RedirectView redirectView = new RedirectView();
                     redirectView.setContextRelative(true);
                     redirectView.setUrl("/FailedSellerSignup.jsp");
                     return redirectView;
                 }
            }

        Seller seller1 =sellerRepository.findById(seller_id).orElse(null);
        seller1.setSellerName(seller_name);
        seller1.setSellerAddress(seller_address);
        seller1.setShopName(shop_name);
        seller1.setSellerEmailId(seller_emailId);
        seller1.setSellerContactNo(seller_contactNo);
        seller1.setSellerPassword(password);
        sellerService.save(seller1);
        session.setAttribute("sellerContactNo", seller1.getSellerContactNo());
        session.setAttribute("sellerAddress", seller1.getSellerAddress());
        session.setAttribute("sellerName", seller1.getSellerName());
        session.setAttribute("sellerEmailId", seller1.getSellerEmailId());
        session.setAttribute("shopName", seller1.getShopName());
        session.setAttribute("sellerPassword",seller1.getSellerPassword());

        //redirecting
        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+Long.toString(seller1.getSellerId());
        rv.setUrl(rurl);
        return rv;
    }

}
