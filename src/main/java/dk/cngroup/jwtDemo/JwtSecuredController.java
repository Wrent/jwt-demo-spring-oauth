package dk.cngroup.jwtDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JwtSecuredController {

    @RequestMapping(path = "/api/jwtSecured", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorldJwt() {
        return "Hello JWT secured world";
    }
}
