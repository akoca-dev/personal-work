package com.akoca.mvc.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/requestMapAndParamTest")
@Controller
public class RequestMapAndParamController {

    private static Logger LOGGER = LoggerFactory.getLogger(RequestMapAndParamController.class);

    @RequestMapping(value = "/home")
    public String home() {
        return "requestMapAndParamHome";
    }

    @RequestMapping(value = "/test1")
    public String testOne(@RequestParam("orgName") String orgName , Model model) {
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("testSerial" , "test1");

        return "requestMapAndParamResults";
    }

    @RequestMapping(value = "/test2" , method = RequestMethod.GET)
    public String testTwo(@RequestParam("orgName") String orgName , Model model) {
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("testSerial" , "test2");

        return "requestMapAndParamResults";
    }

    @RequestMapping(value = "*" , method = RequestMethod.GET)
    public String testThree() {
        return "fallback";
    }

    @RequestMapping(value = "/test4")
    public String testFour(@RequestParam(value = "orgName" , defaultValue = "Any Org")String orgName , Model model) {
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("testSerial" , "test4");
        return "requestMapAndParamResults";
    }

    @RequestMapping(value = "/test5" , method = RequestMethod.GET)
    public String testFive(@RequestParam String orgName , Model model) {
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("testSerial" , "test5");

        return "requestMapAndParamResults";
    }

    @RequestMapping(value = "/test6" , params = "orgName")
    public String testSixSub1(@RequestParam(value = "orgName") String orgName , Model model) {
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("testSerial" , "test6-sub1");

        return "requestMapAndParamResults2";
    }

    @RequestMapping(value = "/test6" , params = "empCount")
    public String testSixSub2(@RequestParam(value = "empCount")String empCount , Model model) {
        model.addAttribute("theEmpCount" , empCount);
        model.addAttribute("testSerial" , "test6-sub2");

        return "requestMapAndParamResults2";
    }

    @RequestMapping(value = {"/test6" , "/test7" } , params = {"empCount" , "orgName=mm" , "since" , "area"})
    public String testSixSub3(@RequestParam(value = "empCount")String empCount ,
                              @RequestParam(value = "orgName") String orgName ,
                              @RequestParam(value = "since") String since ,
                              @RequestParam(value = "area") String area , Model model ,
                              HttpServletRequest request) {
        //These are unnecessary when using param implicit object
        model.addAttribute("theEmpCount" , empCount);
        model.addAttribute("theOrgName" , orgName);
        model.addAttribute("since" , since);
        model.addAttribute("area" , area);

        model.addAttribute("testSerial", "test6-sub3");

        if(request.getRequestURL().toString().contains("test6")) {
            model.addAttribute("testSerial", "test6-sub3");
        } else {
            model.addAttribute("testSerial", "test7");
        }

        return "requestMapAndParamResults2";
    }
}