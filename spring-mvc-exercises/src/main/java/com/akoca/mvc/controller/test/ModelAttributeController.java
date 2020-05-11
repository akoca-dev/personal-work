package com.akoca.mvc.controller.test;

import com.akoca.mvc.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/modelAttributeTest")
public class ModelAttributeController {

    private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeController.class);

    @RequestMapping("/home")
    public String home() {
        LOGGER.info("In home: " + System.currentTimeMillis());

        return "modelAttrHome";
    }

    @RequestMapping("/home2")
    public ModelAndView homeTwo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("anAddress" , new Address());
        mav.setViewName("modelAttrHome");

        return mav;
    }

    @RequestMapping(value = "/home3")
    public ModelAndView homeThree() {
        ModelAndView mav = new ModelAndView("modelAttrHome");
        mav.addObject("anAddress" , new Address());

        return mav;
    }

    @RequestMapping(value = "/home4")
    public ModelAndView homeFour() {
        return new ModelAndView("modelAttrHome" , "anAddress" , new Address("ist" , "34343"));
    }

    @RequestMapping(value = "/home5")
    public String homeFive(Model model) {
        model.addAttribute("anAddress" , new Address("ank" , "06"));

        return "modelAttrHome";
    }

    @RequestMapping(value = "/test5" , method = RequestMethod.POST)
    public String modelAttrAtParam1(@ModelAttribute("anAddress") Address anAddress , ModelMap modelMap) {
        modelMap.addAttribute("newTestData1" , anAddress.getCity());
        modelMap.addAttribute("newTestData2" , anAddress.getZipCode());

        return "modelAttrTest";
    }

    @RequestMapping("/modelAttrTest")
    @ModelAttribute("newTestData3")
    public Address modelAttrDefaultViewName() {
        return new Address("van" , "2324");
    }

    @ModelAttribute
    public void addAttributesToModel1(Model model) {
        LOGGER.info("At add1: " + System.currentTimeMillis());
        model.addAttribute("testData1A" , "Welcome to test bed");
        model.addAttribute("testData1B" , "We will test both usages");
    }

    @ModelAttribute(value = "testData2")
    public String addAttributeToModel2() {
        LOGGER.info("At add2: " + System.currentTimeMillis());

        return "From test 2";
    }

    @ModelAttribute(name = "testData3")
    public Address addAttributeToModel3() {
        LOGGER.info("At add2: " + System.currentTimeMillis());

        return new Address("ist" , "kartal");
    }

    @ModelAttribute
    public Address addAttributeToModel4() {
        LOGGER.info("At add2: " + System.currentTimeMillis());

        return new Address("ank" , "623943443");
    }


}
