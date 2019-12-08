package io.keyell.easyboot.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangke 创建于 2019-12-08
 */

@Controller
@RequestMapping("/")
public class LoginController {


//    @RequestMapping(value = "/logindo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String getProduct(HttpServletRequest request) {
//        //for debug
//
//        String um = request.getParameter("username");
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return "home";
//    }
}
