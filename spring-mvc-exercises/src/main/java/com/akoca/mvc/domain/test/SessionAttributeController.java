package com.akoca.mvc.domain.test;

import com.akoca.mvc.controller.test.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(names = {"visitorData" , "visitorCount"})
@RequestMapping("/registerVisitor")
public class SessionAttributeController {

    @Autowired
    public VisitorService visitorService;

    private static Logger LOGGER = LoggerFactory.getLogger(SessionAttributeController.class);

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("test/sessionAttrViews/sessionAttrHome" , "visitorStats" , new VisitorData());
    }

    @ModelAttribute("visitorData")
    public VisitorData addVisitorData() {
        List<Visitor> visitors = new ArrayList<>();

        return new VisitorData(null , null , visitors);
    }

    @ModelAttribute("visitorCount")
    public VisitorCount countVisitors() {
        return new VisitorCount(0);
    }

    @RequestMapping(value = "/visitor" , method = RequestMethod.POST)
    public String getVisitors(@ModelAttribute("visitorData") VisitorData currentVisitor ,
                              HttpSession httpSession ,
                              SessionStatus sessionStatus ,
                              HttpServletRequest httpServletRequest ,
                              @SessionAttribute("sessionStartTime")LocalDateTime startTime ,
                              @RequestAttribute("currentTime") LocalDateTime clockTime ,
                              Model model) {

        VisitorData visitorDataFromSession = (VisitorData)httpSession.getAttribute("visitorData");
        visitorService.registerVisitor(visitorDataFromSession , currentVisitor);
        VisitorCount visitorCount = (VisitorCount)httpSession.getAttribute("visitorCount");
        visitorService.updateCount(visitorCount);

        long currentSessionDuration = visitorService.computeDuration(startTime);

        if(5 == visitorCount.getCount()) {
            sessionStatus.setComplete();
            httpSession.invalidate();
        }

//        model.addAttribute("timeHeading" , visitorService.describeCurrentTime(clockTime));
//        model.addAttribute("durationHeading" , visitorService.describeCurrentDuration(currentSessionDuration));

        //Alternative to above two lines
        Map<String , Object> modelMap = model.asMap();
        modelMap.put("timeHeading" , visitorService.describeCurrentTime((clockTime)));
        modelMap.put("durationHeading" , visitorService.describeCurrentDuration(currentSessionDuration));

        LOGGER.info(visitorDataFromSession.toString());

        if(httpServletRequest.getMethod().equalsIgnoreCase("post")) {
            LOGGER.info("This is a post request");
        } else {
            LOGGER.info("This is a get request");
        }

        return "test/sessionAttrViews/sessionAttrResult";
    }
}
