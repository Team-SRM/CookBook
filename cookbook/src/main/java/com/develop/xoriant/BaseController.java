package com.develop.xoriant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pritesh Baviskar
 * Date: 4/25/2018
 */

@Controller

public class BaseController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome() {
        return "Hello lalala!";
    }
}
