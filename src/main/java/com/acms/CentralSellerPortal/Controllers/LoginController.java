
package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class LoginController {





        @Autowired
        SellerRepository sellerRepository;
        //@Autowired
        //CompanyRepository companyRepository;

       


        @GetMapping("/seller")
      public Seller create( @RequestParam("email") String email,
                               @RequestParam("password") String password){

        List<sellerRepository> seller = sellerRepository.findAll(body.get("email")).orElse(null);
        for(seller s:list){
          if(body.get("password").equals(s.getPassword())){


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
