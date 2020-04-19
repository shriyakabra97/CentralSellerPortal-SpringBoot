/* author Anmol Tuteja
Session Controller has api for destroying the session while logging out
 */

package com.acms.CentralSellerPortal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class SpringSessionController {

    @RequestMapping(value="/destroy" )
        public RedirectView destroyingSession(HttpSession session)
    {
        session.invalidate();
        return new RedirectView("/");
    }


}
