package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {





    @Autowired
    SellerRepository sellerRepository;
    //@Autowired
    //CompanyRepository companyRepository;




    @RequestMapping(value="/verifyseller" , method=RequestMethod.GET)
    public RedirectView create(@RequestParam("s_mobile") String s_mobile,
                               @RequestParam("s_password") String s_password , RedirectAttributes redirectAttrs){
        List<Seller> seller = new ArrayList<Seller>();
        seller = sellerRepository.findAll();

        for(Seller s: seller){
            if((s_password).equals(s.getSellerPassword()) && (s_mobile).equals(s.getSellerContactNo())){

                RedirectView rv = new RedirectView();
                String rurl="/SellerDashboard.jsp?id="+Long.toString(s.getSellerId());
                rv.setUrl(rurl);
                return rv;

            }

        }
        RedirectView rv = new RedirectView();
        String failLogin = "/FailedLogin.jsp";
        rv.setUrl(failLogin);

        return rv;
    }
   /* @GetMapping("/company")
  public Company create(@RequestBody Map<String,String> body){
    List<companyRepository> company = companyRepository.findAll(body.get("email")).orElse(null);
    for(company c:list){
      if(body.get("password").equals(c.getPassword())){
      return c;
  }
}
  return null;
}*/
}