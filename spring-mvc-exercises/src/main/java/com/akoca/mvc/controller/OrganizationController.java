package com.akoca.mvc.controller;

import com.akoca.mvc.domain.Organization;
import com.akoca.mvc.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/location")
    public String addLocation() {

        return "location";
    }

    @RequestMapping("/listOrgs")
    public String listOrganizations(Model model) {
        List<Organization> organizationList = organizationService.getOrgList();
        model.addAttribute("myOrgList" , organizationList);

        return "listOrganizations";
    }
}
