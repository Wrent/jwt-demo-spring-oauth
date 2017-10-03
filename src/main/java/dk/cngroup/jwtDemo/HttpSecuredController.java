package dk.cngroup.jwtDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpSecuredController {

    @RequestMapping(path = "/http/httpSecured", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorldHttp() {
        return "Hello HTTP secured world";
    }
}
