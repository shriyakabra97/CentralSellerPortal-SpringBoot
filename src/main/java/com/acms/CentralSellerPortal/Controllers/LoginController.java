
package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

       


        @GetMapping("/seller")
      public Seller create( @RequestParam("email") String email,
                               @RequestParam("password") String password){
            List<Seller> seller = new ArrayList<Seller>();
            seller = sellerRepository.findAll();
        for(Seller s: seller){
            if((password).equals(s.getSeller_password()) && (email).equals(s.getSeller_emailId())){


          return s;
      }

    }
    return null;
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
